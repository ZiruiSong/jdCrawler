package com.wenshi.crawler.config;

public class VisitUrlConfig {
	
	/*
	 * 登录url
	 */
	public final static String LOGIN_URL = "https://login.taobao.com/member/login.jhtml?from=taobaoindex&f=top&style=&sub=true&redirect_url=https%3A%2F%2Fmyseller.taobao.com%2Fseller_admin.htm";

	/*
	 * 等待发货订单列表url
	 */
	public final static String WAITSEND_LIST_URL = "https://trade.taobao.com/trade/itemlist/list_sold_items.htm?action=itemlist/SoldQueryAction&event_submit_do_query=1&auctionStatus=PAID&tabCode=waitSend";
	/*
	 * 订单详情页url
	 */
	public final static String TRADE_DETAIL_URL = "https://trade.tmall.com/detail/orderDetail.htm?spm=a1z09.1.0.0.15c63606P7thtr&bizOrderId=";


}
