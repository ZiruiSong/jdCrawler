package com.wenshi.crawler.entity;

public class SubTaobaoOrder {
    private String goodsTitle;
    private String goodsNbr;
    private String goodsSize;
    private String singlePrice;
    private String goodsNum;
    private String youHui;
    private String subState;
    private String custNo;//自定义单号
    public String getGoodsTitle() {
        return goodsTitle;
    }
    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }
    public String getGoodsNbr() {
        return goodsNbr;
    }
    public void setGoodsNbr(String goodsNbr) {
        this.goodsNbr = goodsNbr;
    }
    public String getGoodsSize() {
        return goodsSize;
    }
    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }
    public String getSinglePrice() {
        return singlePrice;
    }
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
    public String getGoodsNum() {
        return goodsNum;
    }
    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
    public String getYouHui() {
        return youHui;
    }
    public void setYouHui(String youHui) {
        this.youHui = youHui;
    }
    public String getSubState() {
        return subState;
    }
    public void setSubState(String subState) {
        this.subState = subState;
    }
    public String getCustNo() {
        return custNo;
    }
    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

}
