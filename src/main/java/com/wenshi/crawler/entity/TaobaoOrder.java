package com.wenshi.crawler.entity;

import java.util.List;

public class TaobaoOrder {
    private String orderId;
    private String createTime;
    private String custAddress;
    private String colorFlag;
    private String custName;
    private String custPhone;
    private String zip;
    private String mJSays;
    private String mJName;
    private List<SubTaobaoOrder> subOrders;
    private String totalPrice;//商品总价
    private String shopYouhui;//店铺优惠
    private String yunFei;//运费
    private String shouldPay;//应收款
    private String returnPoints;//返点积分
    private String beiZhu;//备注
    private String subCounts;//子订单的数量
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCustAddress() {
        return custAddress;
    }
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustPhone() {
        return custPhone;
    }
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getmJSays() {
        return mJSays;
    }
    public void setmJSays(String mJSays) {
        this.mJSays = mJSays;
    }
    public String getmJName() {
        return mJName;
    }
    public void setmJName(String mJName) {
        this.mJName = mJName;
    }
    public List<SubTaobaoOrder> getSubOrders() {
        return subOrders;
    }
    public void setSubOrders(List<SubTaobaoOrder> subOrders) {
        this.subOrders = subOrders;
    }
    public String getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getShopYouhui() {
        return shopYouhui;
    }
    public void setShopYouhui(String shopYouhui) {
        this.shopYouhui = shopYouhui;
    }
    public String getYunFei() {
        return yunFei;
    }
    public void setYunFei(String yunFei) {
        this.yunFei = yunFei;
    }
    public String getShouldPay() {
        return shouldPay;
    }
    public void setShouldPay(String shouldPay) {
        this.shouldPay = shouldPay;
    }
    public String getReturnPoints() {
        return returnPoints;
    }
    public void setReturnPoints(String returnPoints) {
        this.returnPoints = returnPoints;
    }
    public String getBeiZhu() {
        return beiZhu;
    }
    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }
    public String getSubCounts() {
        return subCounts;
    }
    public void setSubCounts(String subCounts) {
        this.subCounts = subCounts;
    }

    public String getColorFlag() {
        return colorFlag;
    }

    public void setColorFlag(String colorFlag) {
        this.colorFlag = colorFlag;
    }
}
