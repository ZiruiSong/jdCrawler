package com.wenshi.crawler.config;

public class PageXpathConfig {

	/*
	小象图片,点击收起左侧工具栏
	 */
	public final static String XIAO_XIANG_IMG = "//*[@id=\"list-sold-items\"]/div[7]/div/div/img";

	/**
	 * 显示更多页码
	 *
	 * //*[@id="sold_container"]/div/div[6]/div[17]/div[2]/div/div[2]/button
	 */
	public final static String MORE_PAGE = "//*[@id=\"sold_container\"]/div/div[6]/div[17]/div[2]/div/div[2]/button";

	/*
	 *下一页按钮
	 *
	 * //*[@id="sold_container"]/div/div[6]/div[17]/div[2]/div/div[1]/ul/li[9]
	 *
	 * //*[@id="sold_container"]/div/div[6]/div[17]/div[2]/div/div[1]/ul/li[9]/a
	 *
	 * //*[@id="sold_container"]/div/div[6]/div[1]/div[3]/div/button[2]
	 */
	public final static String NEXT_PAGE = "//*[@id=\"sold_container\"]/div/div[6]/div[1]/div[3]/div/button[2]";

	/*
	 * 交易编号XPATH前缀
	 *
	 * //*[@id="sold_container"]/div/div[6]/div[2]/table[1]/tbody/tr/td[1]/label/span[3]
	 * //*[@id="sold_container"]/div/div[6]/div[4]/table[1]/tbody/tr/td[1]/label/span[3]
	 */
	public final static String ORDER_ID_XPATH_PREFIX = "//*[@id=\"sold_container\"]/div/div[6]/div[";
	
	/*
	交易编号后缀
	 */
	public final static String ORDER_ID_XPATH_SUFFIX = "]/table[1]/tbody/tr/td[1]/label/span[3]";
	/*
	 * 付款时间
	 */
	public final static String CREATE_TIME_XPATH = "//*[@id=\"appStepbar\"]/div/ol/li[1]/div/div[3]/div";

	/*
	 * 收货信息
	 */
	public final static String CUST_ADDRESS_XPATH = "//*[@id=\"J_trade_imfor\"]/div/ul/li[1]/div[2]/span";
	/*
	 * 买家留言
	 * //*[@id="J_trade_imfor"]/div/ul/li[2]/div[2]/span
	 * //*[@id="J_trade_imfor"]/div/ul/li[3]/div[2]/span
	 */
	public final static String MJ_LIUYAN_XPATH = "//*[@id=\"J_trade_imfor\"]/div/ul/li[2]/div[2]/span";
	/*
	 * 买家留言2
	 * //*[@id="J_trade_imfor"]/div/ul/li[2]/div[2]/span
	 * //*[@id="J_trade_imfor"]/div/ul/li[3]/div[2]/span
	 */
	public final static String MJ_LIUYAN_XPATH_2 = "//*[@id=\"J_trade_imfor\"]/div/ul/li[3]/div[2]/span";

	/*
	 * 买家账号
	 * //*[@id="J_trade_imfor"]/div/ul/li[4]/div[1]/span[1]
	 * //*[@id="J_trade_imfor"]/div/ul/li[4]/div[2]/span/span/span
	 */
	public final static String MJ_ACCOUNT_XPATH = "//*[@id=\"J_trade_imfor\"]/div/ul/li[4 or 5]/div[2]/span/span/span[@class='short-dd-nick']";

	/*
	 * 子订单XPATH前缀
	 */
	public final static String SUB_ORDER_XPATH_PREFIX = "//*[@id=\"appOrders\"]/div/table/tbody/tr/td/ul/li/table";
	/*
	 * 商品标题
	 */
	public final static String SUB_ORDER_TITLE_XPATH_SUFFIX = "/tbody/tr/td[1]/div/div[2]/a";
	/*
	 * 单价
	 */
	public final static String SUB_ORDER_SINGLE_PRICE_XPATH_SUFFIX = "/tbody/tr/td[2]/div/span";
	/*
	 * 数量
	 */
	public final static String SUB_ORDER_ITEM_COUNT_XPATH_SUFFIX = "/tbody/tr/td[3]";
	/*
	 * 子订单优惠
	 */
	public final static String SUB_ITEM_YOUHUI_XPATH_SUFFIX = "/tbody/tr/td[4]";
	
	/*
	 * 子订单状态
	 */
	public final static String SUB_ITEM_STATE_XPATH_SUFFIX = "/tbody/tr/td[5]/div/span";
	/*
	 * 子订单属性
	 */
	public final static String SUB_ITEM_GOODSNBR_XPATH_SUFFIX = "/tbody/tr/td[1]/div/div[2]/div/span[1]/span[2]/span";
	/*
	 * 子订单尺码
	 */
	public final static String SUB_ITEM_GOODSSIZE_XPATH_SUFFIX = "/tbody/tr/td[1]/div/div[2]/div/span[2]/span[2]/span";
	
	/*
	 * 商品总价
	 */
	public final static String TOTAL_GOODS_PRICE_XPATH = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[1]/table/tbody/tr/td/span/div/div/span[3]";
	/*
	 * 主订单运费
	 * //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[3]/table/tbody/tr/td/span/div/div/span[3]
	 */
	public final static String YUNFEI_XPATH = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[2]/table/tbody/tr/td/span/div/div/span[3]";
	/*
	 * 订单总价（含邮），没有主订单优惠时
	 */
	public final static String TOTAL_PRICE = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[4]/table/tbody/tr/td/span/div/div/span[3]";

	/*
	 * 主订单总价（含邮），有主订单优惠时
	 */
	public final static String TOTAL_PRICE_XPATH = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[3]/table/tbody/tr/td/span/div/div/span[3]";
	/*
	 * 应收款
	 * //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[3]/div/table/tbody/tr/td/span/div/div/span[1]
	 */
	public final static String SHOULD_PAY_XPATH = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[3]/table/tbody/tr/td/span/div/div/span[3]";
	/*
	 * 返点积分
	 */
	public final static String RETURN_POINTS_XPATH = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[1]/ul/li/div/span[2]/div/div/span";
	/*
	 * 订单备注
	 */
	public final static String ORDER_BEIZHU_XPATH = "//*[@id=\"J_trade_detail\"]/div/div[1]/dl[2]/dd[2]/span[2]";
}
