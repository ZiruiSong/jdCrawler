package com.wenshi.crawler.service;

import com.wenshi.crawler.config.ClientConfig;
import com.wenshi.crawler.dao.TaobaoOrderDao;
import com.wenshi.crawler.entity.FxOrdersTaobao;
import com.wenshi.crawler.entity.SubTaobaoOrder;
import com.wenshi.crawler.entity.TaobaoOrder;
import com.wenshi.crawler.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/*
订单服务类
 */
@Service
public class OrderService {




    @Autowired
    private  TaobaoOrderDao taobaoOrderDao;

    @Autowired
    private  FxAreaService areaService;



    /*
    Test
     */
    public   List<FxOrdersTaobao> findAllByPageable(){
        return taobaoOrderDao.findAll(new PageRequest(0,10)).getContent();
    }



    public  List<FxOrdersTaobao> dealTaobaoOrder(TaobaoOrder crawlerOrder, Long userId, Long shopId){
        //初始化省市区map
        if(null == areaService.map){
            areaService.getAreaMap();
        }
        List<FxOrdersTaobao> taobaoOrdersList = new ArrayList<>();
        String custInfo = crawlerOrder.getCustAddress();
        //主订单号
        String tid = crawlerOrder.getOrderId();
        //收货人姓名
        String custName = CustAddrUtil.findCustName(custInfo);
        //收货人电话
        String custTel = CustAddrUtil.findCustTel(custInfo);
        //收货人的地址
        String custAddress = CustAddrUtil.findCustAddress(custInfo);
        //付款时间
        String createTimeString = crawlerOrder.getCreateTime();
        //买家备注
        String buyermemo = crawlerOrder.getmJSays();
        //订单备注
        String sellermemo = crawlerOrder.getBeiZhu();
        //买家昵称
        String buyNick = crawlerOrder.getmJName();
        //实付款
        String payment = crawlerOrder.getShouldPay();
        //总价(含邮)
        String totalPrice = crawlerOrder.getTotalPrice();
        //邮费
        String postFee = crawlerOrder.getYunFei();

        //旗帜颜色
        /////////////////////////////////////
        List<SubTaobaoOrder> subTaobaoOrders = crawlerOrder.getSubOrders();
        if(null == subTaobaoOrders || subTaobaoOrders.size() == 0){
            return null;
        }
        try {
            //使用百度Map接口解析省市区
            Map<String,String> baiduMap = BaiduMapUtil.getAddressComponent(custAddress);

            int i=0;
            //遍历子订单
            for (SubTaobaoOrder subTaobaoOrder : subTaobaoOrders) {
                //每个子订单转成FxOrdersTaobao对象
                FxOrdersTaobao ordersTaobao = new FxOrdersTaobao();
                //商品标题
                String title = subTaobaoOrder.getGoodsTitle();
                //货号
                String goodsNbr = subTaobaoOrder.getGoodsNbr();
                //尺码
                String goodsSize = subTaobaoOrder.getGoodsSize();
                //单价
                String singlePrice = subTaobaoOrder.getSinglePrice();
                //优惠
                String youhui = subTaobaoOrder.getYouHui();
                //数量
                String goodsCount = subTaobaoOrder.getGoodsNum();
                //商品信息改为从数据库获取，规范货号匹配，但存入数据库的依然时未经转换的货号
                String goodsNbrCnv = GoodsNbrUtil.goodsNbrConver(goodsNbr);
                String goodsSizeCnv = GoodsSizeUtil.sizeConver(goodsSize);
                //收货人姓名
                ordersTaobao.setCustName(custName);
                //地址
                ordersTaobao.setCustAddr(custAddress);
                ordersTaobao.setCustTel(MD5Util.getBASE64(custTel != null ? custTel : ""));
                //省
                String provinceName = baiduMap.get(BaiduMapUtil.PROVINCE);
                //市
                String cityName = baiduMap.get(BaiduMapUtil.CITY);
                //区
                String district = baiduMap.get(BaiduMapUtil.DISTRICT);
                ordersTaobao.setProvinceName(provinceName);
                ordersTaobao.setProvinceId(areaService.map.get(provinceName));
                ordersTaobao.setCityName(cityName);
                ordersTaobao.setCityId(areaService.map.get(cityName));
                ordersTaobao.setCountryName(district);
                ordersTaobao.setCountryId(areaService.map.get(district));
                ordersTaobao.setEmsComp("");
                ordersTaobao.setRemarkBuy(buyermemo);
                ordersTaobao.setKefuUserName("");
                ordersTaobao.setChannelName("");
                ordersTaobao.setSex("女");
                ordersTaobao.setRemarkSell("-");
                //旗帜颜色
                if(Objects.isNull(sellermemo)){
                    //0(灰色), 1(红色), 2(黄色), 3(绿色), 4(蓝色), 5(粉红色)，默认值为0
                    ordersTaobao.setRemarkColor("0");
                    //卖家备注
                    ordersTaobao.setRemarkSell("-");
                    //订单备注
                    ordersTaobao.setOrderRemark("-");
                }else {
                    //客服姓名
                    String kefuName = OrderRemarkUtil.getKefuName(sellermemo);
                    //快递
                    String kuaidi = OrderRemarkUtil.getKuaidi(sellermemo);
                    ordersTaobao.setKefuUserName(kefuName);
                    ordersTaobao.setEmsComp(kuaidi);
                    ordersTaobao.setRemarkColor("5");
                    //订单备注
                    ordersTaobao.setOrderRemark(sellermemo);
                }
                ordersTaobao.setBuyerNick(buyNick);
                ordersTaobao.setGoodsTypeName("配件");
                //爬虫获取不到sku
                ordersTaobao.setSkuId("");
                ordersTaobao.setOrigin((short) 1);
                ordersTaobao.setUserId(ClientConfig.USER_ID);
                ordersTaobao.setShopId(ClientConfig.SHOP_ID);
                ordersTaobao.setTid(tid);
                //淘宝平台numiid为商品的数字id，此处为子订单号
                ordersTaobao.setNumiid(tid+i+"");//自己编造的子订单号
                ordersTaobao.setNumiid(ordersTaobao.getNumiid().replace(" ",""));
                ordersTaobao.setCreatedTime(new Timestamp(DateUtil.SDF.parse(createTimeString).getTime()));
                ordersTaobao.setTitle(title);
                ordersTaobao.setBrand("");
                ordersTaobao.setGoodsNbr(goodsNbrCnv);
                ordersTaobao.setGoodsSize(goodsSize);
                ordersTaobao.setGoodsSizeTrans(goodsSizeCnv);
                ordersTaobao.setGoodsCount(Long.parseLong(goodsCount));
                ordersTaobao.setGoodsPriceOrg(Float.parseFloat(singlePrice));
                if(null != youhui && !"".equals(youhui)){
                    ordersTaobao.setDiscountFee(Float.parseFloat(youhui));
                    //优惠分摊
                    ordersTaobao.setPartMjzDiscount(Float.parseFloat(youhui));
                }else{
                    ordersTaobao.setDiscountFee(0f);
                    ordersTaobao.setPartMjzDiscount(0f);
                }
                ordersTaobao.setPrice(Float.parseFloat(singlePrice));
                //实付款，这里是所有子订单的实付款之和
                ordersTaobao.setPayment(Float.parseFloat(payment));
                ordersTaobao.setDivideOrderFee(Float.parseFloat(payment));
                ordersTaobao.setTotalFee(Float.parseFloat(totalPrice));
                ordersTaobao.setPostFee(Float.parseFloat(postFee));
                ordersTaobao.setLogisticsType((short) 1);
                ordersTaobao.setState((short) 0);
                ordersTaobao.setIsExport((short) 0);
                ordersTaobao.setIsFahuo((short) 0);
                ordersTaobao.setDownloadTime(new Timestamp(new Date().getTime()));
                //ordersTaobao.setCustName();
                //先判断是否存在
                Set<FxOrdersTaobao> setOrders = taobaoOrderDao.findByShopIdAndNumiid(ClientConfig.SHOP_ID,ordersTaobao.getNumiid());
                if(null == setOrders || setOrders.isEmpty()){
                    System.out.println(ordersTaobao.toString());
                    taobaoOrdersList.add(ordersTaobao);
                }
                i++;
            }

            if(taobaoOrdersList.size()>0){

                try {
                    taobaoOrderDao.save(taobaoOrdersList);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){//百度地图接口抛出的异常
            System.out.println("解析收货人地址出错了~");
            System.out.println(custAddress);
//            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("下单时间格式化出错了~");
        }catch (NullPointerException e){

        }
        return taobaoOrdersList;
    }


    /*
    根据店铺名和子订单号查询订单是否已经下载过
     */
    public  Set<FxOrdersTaobao> findOrdersByShopIdAndNumiid(Long shopId,String numiid){
       return taobaoOrderDao.findByShopIdAndNumiid(shopId,numiid);
    }

    /**
     * 批量保存淘宝订单到数据库
     * @param taobaoOrdersList
     */
    @Transactional
    public void saveAllTaobaoOrders(List<FxOrdersTaobao> taobaoOrdersList){
        taobaoOrderDao.save(taobaoOrdersList);
    }
}
