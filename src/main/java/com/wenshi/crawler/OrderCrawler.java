package com.wenshi.crawler;

import com.wenshi.crawler.config.ClientConfig;
import com.wenshi.crawler.config.PageXpathConfig;
import com.wenshi.crawler.config.VisitUrlConfig;
import com.wenshi.crawler.entity.FxOrdersTaobao;
import com.wenshi.crawler.entity.SubTaobaoOrder;
import com.wenshi.crawler.entity.TaobaoOrder;
import com.wenshi.crawler.service.OrderService;
import com.wenshi.crawler.util.BrowserParam;
import com.wenshi.crawler.util.ImgCopyUtil;
import com.wenshi.crawler.util.XpathUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
订单爬虫
 */
@Component("orderCrawler")
public class OrderCrawler {

    @Autowired
    private OrderService orderService;

    /*
     * 判断是否登录成功标识
     */
    private final static String URL_FLAG = "mai.taobao.com";

    public void chromeCrawlerRun() {
        //带参数启动Chrome浏览器
        WebDriver driver = new ChromeDriver(BrowserParam.initChrome());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //最大化
        driver.navigate().to(VisitUrlConfig.LOGIN_URL);
        //截图二维码
        WebElement loginWindow = driver.findElement(By.xpath("//*[@id=\"J_LoginBox\"]"));
//        loginWindow.
        File loginImg = loginWindow.getScreenshotAs(OutputType.FILE);
        //图片保存的路径
        String path = loginImg.getAbsolutePath();

        //拷贝图片到指定位置
        ImgCopyUtil.copyImg(path,"C:\\shoplogin2code.png");
        //alertLoginImg(path);
        //手动登录
        while(!driver.getCurrentUrl().contains(URL_FLAG)){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("系统休眠出错了~");
            }
        }
        int t=0;
        driver.navigate().to(VisitUrlConfig.WAITSEND_LIST_URL);
        //JOptionPane.showMessageDialog(null,"登录成功~");
        System.out.println("登录成功~");
        List<FxOrdersTaobao> list = new ArrayList<>();
        List<String> tradeOrderIds = new LinkedList<String>();
        //收集页面的交易编号
        for (int i = 2; i < 17; i++) {
            String orderId = driver.findElement(By.xpath(PageXpathConfig.ORDER_ID_XPATH_PREFIX + i + PageXpathConfig.ORDER_ID_XPATH_SUFFIX)).getText();
            tradeOrderIds.add(orderId);
        }
        // 小象图片 //*[@id="list-sold-items"]/div[7]/div/div/img
        // 收起右侧工具栏
        try {
            WebElement webElement = driver.findElement(By.xpath(PageXpathConfig.XIAO_XIANG_IMG));
            if(null != webElement){
                webElement.click();
            }
        }catch (NoSuchElementException e){
            System.out.println("没有找到这个Element~");
        }

        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //显示更多页码
        WebElement morePage = driver.findElement(By.xpath(PageXpathConfig.MORE_PAGE));
        morePage.click();
        WebElement nextPageEle = driver.findElement(By.xpath(PageXpathConfig.NEXT_PAGE));
        while(nextPageEle.isEnabled()){
            t++;
            if(t>400){
                break;
            }
            try {
                nextPageEle.click();
            }catch (ElementClickInterceptedException e){
                WebElement webElement = driver.findElement(By.xpath(PageXpathConfig.XIAO_XIANG_IMG));
                if(null != webElement){
                    webElement.click();
                }
            }catch (NoSuchElementException e){
                System.out.println("没有找到这个Element~");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //收集页面的交易编号
            for (int i = 2; i < 17; i++) {
                try {
                    WebElement orderIdEle = driver.findElement(By.xpath(PageXpathConfig.ORDER_ID_XPATH_PREFIX + i + PageXpathConfig.ORDER_ID_XPATH_SUFFIX));
                    if(null != orderIdEle){
                        String orderId = orderIdEle.getText();
                        tradeOrderIds.add(orderId);
                    }else{

                    }
                }catch (NoSuchElementException e){
                    System.out.println("没有找到这个Element~");
                }catch (StaleElementReferenceException e){
                    continue;
                }
            }
            nextPageEle = driver.findElement(By.xpath(PageXpathConfig.NEXT_PAGE));
        }
        for(int k=0;k<tradeOrderIds.size();k++){
            TaobaoOrder taobaoOrder = new TaobaoOrder();

            //跳转到订单详情页面
            driver.navigate().to(VisitUrlConfig.TRADE_DETAIL_URL+tradeOrderIds.get(k));
            //主订单号
            taobaoOrder.setOrderId(tradeOrderIds.get(k).replace(" ",""));
            //解析收货地址
            String custAddress = driver.findElement(By.xpath(PageXpathConfig.CUST_ADDRESS_XPATH)).getText();
            System.out.println(custAddress);
            taobaoOrder.setCustAddress(custAddress);

            try {
                //买家留言
                String custLiuYan = driver.findElement(By.xpath(PageXpathConfig.MJ_LIUYAN_XPATH)).getText();
                taobaoOrder.setmJSays(custLiuYan);
            }catch (NoSuchElementException e){
                //买家留言
                String custLiuYan = driver.findElement(By.xpath(PageXpathConfig.MJ_LIUYAN_XPATH_2)).getText();
                taobaoOrder.setmJSays(custLiuYan);
            }

            //买家账号
            String mJName = driver.findElement(By.xpath(PageXpathConfig.MJ_ACCOUNT_XPATH)).getText();
            taobaoOrder.setmJName(mJName);

            int i=1;
            //子订单数据
            List<SubTaobaoOrder> subOrders = new LinkedList<>();
            while(i!=-1){
                try{
                    StringBuilder sb = new StringBuilder();
                    SubTaobaoOrder subTaobaoOrder = new SubTaobaoOrder();

                    if(i==1){
                        //单件
                        sb.append("");
                    }else{
                        //多件
                        sb.append("["+i+"]");
                    }
                    //商品标题
                    String goodsTitle = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ORDER_TITLE_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setGoodsTitle(goodsTitle);
                    //单价
                    String singlePrice = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ORDER_SINGLE_PRICE_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setSinglePrice(singlePrice.replace("￥",""));
                    //数量
                    String goodsNum = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ORDER_ITEM_COUNT_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setGoodsNum(goodsNum);
                    //优惠
                    String youHui = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ITEM_YOUHUI_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setYouHui(youHui);
                    //状态
                    String orderState = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ITEM_STATE_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setSubState(orderState);
                    //颜色分类
                    String goodsNbr = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ITEM_GOODSNBR_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setGoodsNbr(goodsNbr);
                    //尺码
                    String gooodsSize = driver.findElement(By.xpath(PageXpathConfig.SUB_ORDER_XPATH_PREFIX+sb.toString()+PageXpathConfig.SUB_ITEM_GOODSSIZE_XPATH_SUFFIX)).getText();
                    subTaobaoOrder.setGoodsSize(gooodsSize);

                    //子订单加入数组
                    subOrders.add(subTaobaoOrder);
                    i++;
                }catch (InvalidSelectorException e) {
                    i=-1;
                }catch (NoSuchElementException e) {
                    i=-1;
                }
            }
            taobaoOrder.setSubOrders(subOrders);

            Map<String,String> totalCountDetailMap = XpathUtil.getTotalCountDetailMap(5,driver);

            /*1.使用静态xpath获取
            //商品总价
            String totalPrice = driver.findElement(By.xpath(PageXpathConfig.TOTAL_GOODS_PRICE_XPATH)).getText();
            taobaoOrder.setTotalPrice(totalPrice.replace("￥",""));
            //运费
            String yunFei = driver.findElement(By.xpath(PageXpathConfig.YUNFEI_XPATH)).getText();
            taobaoOrder.setYunFei(yunFei.replace("￥",""));
            //订单总价（含邮）
            String lastTotalPrice=null;
            try{
                lastTotalPrice = driver.findElement(By.xpath(PageXpathConfig.TOTAL_PRICE)).getText();
            }catch(NoSuchElementException e){
                lastTotalPrice = driver.findElement(By.xpath(PageXpathConfig.TOTAL_PRICE_XPATH)).getText();
            }
            taobaoOrder.setTotalPrice(lastTotalPrice.replace("￥",""));
            //应收款
            String shouldPay = driver.findElement(By.xpath(PageXpathConfig.SHOULD_PAY_XPATH)).getText();
            taobaoOrder.setShouldPay(shouldPay.replace("￥",""));
            */
            //2.使用动态xpath获取
            //商品总价
            String totalPrice = totalCountDetailMap.get("商品总价");

            taobaoOrder.setTotalPrice(totalPrice.replace("￥",""));
            //运费
            String yunFei = totalCountDetailMap.get("运费(快递)");
            taobaoOrder.setYunFei(yunFei.replace("￥",""));
            //订单总价（含邮）
            String lastTotalPrice= totalCountDetailMap.get("订单总价");
            taobaoOrder.setTotalPrice(lastTotalPrice.replace("￥",""));
            //应收款
            String shouldPay = totalCountDetailMap.get("订单总价");
            taobaoOrder.setShouldPay(shouldPay.replace("￥",""));
            //返点积分
            String returnPoints = driver.findElement(By.xpath(PageXpathConfig.RETURN_POINTS_XPATH)).getText();
            taobaoOrder.setReturnPoints(returnPoints);

            //付款时间
            String createTime = driver.findElement(By.xpath(PageXpathConfig.CREATE_TIME_XPATH)).getText();
            taobaoOrder.setCreateTime(createTime);
            String beiZhu = null;
            try{
                //备注
                beiZhu = driver.findElement(By.xpath(PageXpathConfig.ORDER_BEIZHU_XPATH)).getText();
            }catch (NoSuchElementException e) {

            }
            //旗帜颜色

            System.out.println(beiZhu);
            taobaoOrder.setBeiZhu(beiZhu);

            //处理
            if(null == orderService.dealTaobaoOrder(taobaoOrder, ClientConfig.USER_ID,ClientConfig.SHOP_ID)){
                break;
            }

        }
        System.out.println("下载订单任务完成了~");
        //JOptionPane.showMessageDialog(null,"下载订单任务完成了~");
        driver.quit();
    }

    public void alertLoginImg(String imgPath){
        JFrame frame = new JFrame("扫码登录");
        String picPath = imgPath+"";
        System.out.println(picPath);
        Icon icon = new ImageIcon(picPath);
        JLabel jLabel = new JLabel("",icon,JLabel.CENTER);
        jLabel.setBackground(Color.blue);
        jLabel.setForeground(Color.BLACK);
        frame.add(jLabel);
        frame.setSize(600,500);
        frame.setBackground(Color.WHITE);
        frame.setLocation(600,500);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
