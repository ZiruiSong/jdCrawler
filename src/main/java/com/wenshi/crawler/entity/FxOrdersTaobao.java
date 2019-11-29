package com.wenshi.crawler.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * FxOrdersTaobao entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fx_orders_taobao", uniqueConstraints = @UniqueConstraint(columnNames = "numiid"))

public class FxOrdersTaobao implements java.io.Serializable {

    // Fields

    private Long orderId;
    private Long userId;
    private Long shopId;
    private String tid;
    private String numiid;
    private String skuId;
    private Timestamp createdTime;
    private String title;
    private String brand;
    private String goodsNbr;
    private String goodsSize;
    private Long goodsCount;
    private Float goodsPrice;
    private Float goodsPriceOrg;
    private String custName;
    private String custAddr;
    private String custTel;
    private String emsComp;
    private Float emsPrice;
    private String remarkBuy;
    private String remarkSell;
    private String remarkColor;
    private Timestamp downloadTime;
    private String buyerNick;
    private Short isExport;
    private Short isFahuo;
    private String emsId;
    private String errorMsg;
    private String channelName;
    private String kefuUserName;
    private String goodsTypeName;
    private String sex;
    private String goodsSizeTrans;
    private Short state;
    private String orderRemark;
    private Short origin;
    private Long batchId;
    private Long provinceId;
    private String cityName;
    private Long cityId;
    private String countryName;
    private Long countryId;
    private String provinceName;
    private String emsCompOri;
    private Float taobaoOrderPrice;
    private Float postFee;
    private Float orderSumPrice;
    private Float totalFee;
    private Float adjustFee;
    private Float partMjzDiscount;
    private Float divideOrderFee;
    private Float payment;
    private Float price;
    private Float discountFee;
    private Short logisticsType;

    // Constructors

    /** default constructor */
    public FxOrdersTaobao() {
    }

    /** minimal constructor */
    public FxOrdersTaobao(Short isExport, Short isFahuo, Short state) {
	this.isExport = isExport;
	this.isFahuo = isFahuo;
	this.state = state;
    }

    /** full constructor */
    public FxOrdersTaobao(Long userId, Long shopId, String tid, String numiid, String skuId, Timestamp createdTime,
                          String title, String brand, String goodsNbr, String goodsSize, Long goodsCount, Float goodsPrice,
                          Float goodsPriceOrg, String custName, String custAddr, String custTel, String emsComp, Float emsPrice,
                          String remarkBuy, String remarkSell, String remarkColor, Timestamp downloadTime, String buyerNick,
                          Short isExport, Short isFahuo, String emsId, String errorMsg, String channelName, String kefuUserName,
                          String goodsTypeName, String sex, String goodsSizeTrans, Short state, String orderRemark, Short origin,
                          Long batchId, Long provinceId, String cityName, Long cityId, String countryName, Long countryId,
                          String provinceName, String emsCompOri, Float taobaoOrderPrice, Float postFee, Float orderSumPrice,
                          Float totalFee, Float adjustFee, Float partMjzDiscount, Float divideOrderFee, Float payment, Float price,
                          Float discountFee, Short logisticsType) {
	this.userId = userId;
	this.shopId = shopId;
	this.tid = tid;
	this.numiid = numiid;
	this.skuId = skuId;
	this.createdTime = createdTime;
	this.title = title;
	this.brand = brand;
	this.goodsNbr = goodsNbr;
	this.goodsSize = goodsSize;
	this.goodsCount = goodsCount;
	this.goodsPrice = goodsPrice;
	this.goodsPriceOrg = goodsPriceOrg;
	this.custName = custName;
	this.custAddr = custAddr;
	this.custTel = custTel;
	this.emsComp = emsComp;
	this.emsPrice = emsPrice;
	this.remarkBuy = remarkBuy;
	this.remarkSell = remarkSell;
	this.remarkColor = remarkColor;
	this.downloadTime = downloadTime;
	this.buyerNick = buyerNick;
	this.isExport = isExport;
	this.isFahuo = isFahuo;
	this.emsId = emsId;
	this.errorMsg = errorMsg;
	this.channelName = channelName;
	this.kefuUserName = kefuUserName;
	this.goodsTypeName = goodsTypeName;
	this.sex = sex;
	this.goodsSizeTrans = goodsSizeTrans;
	this.state = state;
	this.orderRemark = orderRemark;
	this.origin = origin;
	this.batchId = batchId;
	this.provinceId = provinceId;
	this.cityName = cityName;
	this.cityId = cityId;
	this.countryName = countryName;
	this.countryId = countryId;
	this.provinceName = provinceName;
	this.emsCompOri = emsCompOri;
	this.taobaoOrderPrice = taobaoOrderPrice;
	this.postFee = postFee;
	this.orderSumPrice = orderSumPrice;
	this.totalFee = totalFee;
	this.adjustFee = adjustFee;
	this.partMjzDiscount = partMjzDiscount;
	this.divideOrderFee = divideOrderFee;
	this.payment = payment;
	this.price = price;
	this.discountFee = discountFee;
	this.logisticsType = logisticsType;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public Long getOrderId() {
	return this.orderId;
    }

    public void setOrderId(Long orderId) {
	this.orderId = orderId;
    }

    @Column(name = "user_id")

    public Long getUserId() {
	return this.userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    @Column(name = "shop_id")

    public Long getShopId() {
	return this.shopId;
    }

    public void setShopId(Long shopId) {
	this.shopId = shopId;
    }

    @Column(name = "tid", length = 100)

    public String getTid() {
	return this.tid;
    }

    public void setTid(String tid) {
	this.tid = tid;
    }

    @Column(name = "numiid", unique = true, length = 100)

    public String getNumiid() {
	return this.numiid;
    }

    public void setNumiid(String numiid) {
	this.numiid = numiid;
    }

    @Column(name = "sku_id", length = 100)

    public String getSkuId() {
	return this.skuId;
    }

    public void setSkuId(String skuId) {
	this.skuId = skuId;
    }

    @Column(name = "created_time", length = 19)

    public Timestamp getCreatedTime() {
	return this.createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
	this.createdTime = createdTime;
    }

    @Column(name = "title", length = 200)

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Column(name = "brand", length = 50)

    public String getBrand() {
	return this.brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    @Column(name = "goods_nbr", length = 50)

    public String getGoodsNbr() {
	return this.goodsNbr;
    }

    public void setGoodsNbr(String goodsNbr) {
	this.goodsNbr = goodsNbr;
    }

    @Column(name = "goods_size", length = 200)

    public String getGoodsSize() {
	return this.goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
	this.goodsSize = goodsSize;
    }

    @Column(name = "goods_count")

    public Long getGoodsCount() {
	return this.goodsCount;
    }

    public void setGoodsCount(Long goodsCount) {
	this.goodsCount = goodsCount;
    }

    @Column(name = "goods_price", precision = 12, scale = 0)

    public Float getGoodsPrice() {
	return this.goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
	this.goodsPrice = goodsPrice;
    }

    @Column(name = "goods_price_org", precision = 12, scale = 0)

    public Float getGoodsPriceOrg() {
	return this.goodsPriceOrg;
    }

    public void setGoodsPriceOrg(Float goodsPriceOrg) {
	this.goodsPriceOrg = goodsPriceOrg;
    }

    @Column(name = "cust_name", length = 100)

    public String getCustName() {
	return this.custName;
    }

    public void setCustName(String custName) {
	this.custName = custName;
    }

    @Column(name = "cust_addr", length = 512)

    public String getCustAddr() {
	return this.custAddr;
    }

    public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
    }

    @Column(name = "cust_tel", length = 512)

    public String getCustTel() {
	return this.custTel;
    }

    public void setCustTel(String custTel) {
	this.custTel = custTel;
    }

    @Column(name = "ems_comp", length = 500)

    public String getEmsComp() {
	return this.emsComp;
    }

    public void setEmsComp(String emsComp) {
	this.emsComp = emsComp;
    }

    @Column(name = "ems_price", precision = 12, scale = 0)

    public Float getEmsPrice() {
	return this.emsPrice;
    }

    public void setEmsPrice(Float emsPrice) {
	this.emsPrice = emsPrice;
    }

    @Column(name = "remark_buy", length = 4000)

    public String getRemarkBuy() {
	return this.remarkBuy;
    }

    public void setRemarkBuy(String remarkBuy) {
	this.remarkBuy = remarkBuy;
    }

    @Column(name = "remark_sell", length = 4000)

    public String getRemarkSell() {
	return this.remarkSell;
    }

    public void setRemarkSell(String remarkSell) {
	this.remarkSell = remarkSell;
    }

    @Column(name = "remark_color", length = 50)

    public String getRemarkColor() {
	return this.remarkColor;
    }

    public void setRemarkColor(String remarkColor) {
	this.remarkColor = remarkColor;
    }

    @Column(name = "download_time", length = 19)

    public Timestamp getDownloadTime() {
	return this.downloadTime;
    }

    public void setDownloadTime(Timestamp downloadTime) {
	this.downloadTime = downloadTime;
    }

    @Column(name = "buyer_nick", length = 200)

    public String getBuyerNick() {
	return this.buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
	this.buyerNick = buyerNick;
    }

    @Column(name = "is_export", nullable = false)

    public Short getIsExport() {
	return this.isExport;
    }

    public void setIsExport(Short isExport) {
	this.isExport = isExport;
    }

    @Column(name = "is_fahuo", nullable = false)

    public Short getIsFahuo() {
	return this.isFahuo;
    }

    public void setIsFahuo(Short isFahuo) {
	this.isFahuo = isFahuo;
    }

    @Column(name = "ems_id", length = 100)

    public String getEmsId() {
	return this.emsId;
    }

    public void setEmsId(String emsId) {
	this.emsId = emsId;
    }

    @Column(name = "error_msg", length = 1000)

    public String getErrorMsg() {
	return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
    }

    @Column(name = "channel_name", length = 500)

    public String getChannelName() {
	return this.channelName;
    }

    public void setChannelName(String channelName) {
	this.channelName = channelName;
    }

    @Column(name = "kefu_user_name", length = 150)

    public String getKefuUserName() {
	return this.kefuUserName;
    }

    public void setKefuUserName(String kefuUserName) {
	this.kefuUserName = kefuUserName;
    }

    @Column(name = "goods_type_name", length = 100)

    public String getGoodsTypeName() {
	return this.goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
	this.goodsTypeName = goodsTypeName;
    }

    @Column(name = "sex", length = 200)

    public String getSex() {
	return this.sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    @Column(name = "goods_size_trans", length = 200)

    public String getGoodsSizeTrans() {
	return this.goodsSizeTrans;
    }

    public void setGoodsSizeTrans(String goodsSizeTrans) {
	this.goodsSizeTrans = goodsSizeTrans;
    }

    @Column(name = "state", nullable = false)

    public Short getState() {
	return this.state;
    }

    public void setState(Short state) {
	this.state = state;
    }

    @Column(name = "order_remark", length = 4000)

    public String getOrderRemark() {
	return this.orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
	this.orderRemark = orderRemark;
    }

    @Column(name = "origin")

    public Short getOrigin() {
	return this.origin;
    }

    public void setOrigin(Short origin) {
	this.origin = origin;
    }

    @Column(name = "batch_id")

    public Long getBatchId() {
	return this.batchId;
    }

    public void setBatchId(Long batchId) {
	this.batchId = batchId;
    }

    @Column(name = "province_id")

    public Long getProvinceId() {
	return this.provinceId;
    }

    public void setProvinceId(Long provinceId) {
	this.provinceId = provinceId;
    }

    @Column(name = "city_name", length = 100)

    public String getCityName() {
	return this.cityName;
    }

    public void setCityName(String cityName) {
	this.cityName = cityName;
    }

    @Column(name = "city_id")

    public Long getCityId() {
	return this.cityId;
    }

    public void setCityId(Long cityId) {
	this.cityId = cityId;
    }

    @Column(name = "country_name", length = 100)

    public String getCountryName() {
	return this.countryName;
    }

    public void setCountryName(String countryName) {
	this.countryName = countryName;
    }

    @Column(name = "country_id")

    public Long getCountryId() {
	return this.countryId;
    }

    public void setCountryId(Long countryId) {
	this.countryId = countryId;
    }

    @Column(name = "province_name", length = 500)

    public String getProvinceName() {
	return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
	this.provinceName = provinceName;
    }

    @Column(name = "ems_comp_ori", length = 500)

    public String getEmsCompOri() {
	return this.emsCompOri;
    }

    public void setEmsCompOri(String emsCompOri) {
	this.emsCompOri = emsCompOri;
    }

    @Column(name = "taobao_order_price", precision = 12, scale = 0)

    public Float getTaobaoOrderPrice() {
	return this.taobaoOrderPrice;
    }

    public void setTaobaoOrderPrice(Float taobaoOrderPrice) {
	this.taobaoOrderPrice = taobaoOrderPrice;
    }

    @Column(name = "post_fee", precision = 12, scale = 0)

    public Float getPostFee() {
	return this.postFee;
    }

    public void setPostFee(Float postFee) {
	this.postFee = postFee;
    }

    @Column(name = "order_sum_price", precision = 12, scale = 0)

    public Float getOrderSumPrice() {
	return this.orderSumPrice;
    }

    public void setOrderSumPrice(Float orderSumPrice) {
	this.orderSumPrice = orderSumPrice;
    }

    @Column(name = "total_fee", precision = 12, scale = 0)

    public Float getTotalFee() {
	return this.totalFee;
    }

    public void setTotalFee(Float totalFee) {
	this.totalFee = totalFee;
    }

    @Column(name = "adjust_fee", precision = 12, scale = 0)

    public Float getAdjustFee() {
	return this.adjustFee;
    }

    public void setAdjustFee(Float adjustFee) {
	this.adjustFee = adjustFee;
    }

    @Column(name = "part_mjz_discount", precision = 12, scale = 0)

    public Float getPartMjzDiscount() {
	return this.partMjzDiscount;
    }

    public void setPartMjzDiscount(Float partMjzDiscount) {
	this.partMjzDiscount = partMjzDiscount;
    }

    @Column(name = "divide_order_fee", precision = 12, scale = 0)

    public Float getDivideOrderFee() {
	return this.divideOrderFee;
    }

    public void setDivideOrderFee(Float divideOrderFee) {
	this.divideOrderFee = divideOrderFee;
    }

    @Column(name = "payment", precision = 12, scale = 0)

    public Float getPayment() {
	return this.payment;
    }

    public void setPayment(Float payment) {
	this.payment = payment;
    }

    @Column(name = "price", precision = 12, scale = 0)

    public Float getPrice() {
	return this.price;
    }

    public void setPrice(Float price) {
	this.price = price;
    }

    @Column(name = "discount_fee", precision = 12, scale = 0)

    public Float getDiscountFee() {
	return this.discountFee;
    }

    public void setDiscountFee(Float discountFee) {
	this.discountFee = discountFee;
    }

    @Column(name = "logistics_type")

    public Short getLogisticsType() {
	return this.logisticsType;
    }

    public void setLogisticsType(Short logisticsType) {
	this.logisticsType = logisticsType;
    }

    @Override
    public String toString() {
        return "FxOrdersTaobao{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", shopId=" + shopId +
                ", tid='" + tid + '\'' +
                ", numiid='" + numiid + '\'' +
                ", skuId='" + skuId + '\'' +
                ", createdTime=" + createdTime +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", goodsNbr='" + goodsNbr + '\'' +
                ", goodsSize='" + goodsSize + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                ", goodsPriceOrg=" + goodsPriceOrg +
                ", custName='" + custName + '\'' +
                ", custAddr='" + custAddr + '\'' +
                ", custTel='" + custTel + '\'' +
                ", emsComp='" + emsComp + '\'' +
                ", emsPrice=" + emsPrice +
                ", remarkBuy='" + remarkBuy + '\'' +
                ", remarkSell='" + remarkSell + '\'' +
                ", remarkColor='" + remarkColor + '\'' +
                ", downloadTime=" + downloadTime +
                ", buyerNick='" + buyerNick + '\'' +
                ", isExport=" + isExport +
                ", isFahuo=" + isFahuo +
                ", emsId='" + emsId + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", channelName='" + channelName + '\'' +
                ", kefuUserName='" + kefuUserName + '\'' +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", sex='" + sex + '\'' +
                ", goodsSizeTrans='" + goodsSizeTrans + '\'' +
                ", state=" + state +
                ", orderRemark='" + orderRemark + '\'' +
                ", origin=" + origin +
                ", batchId=" + batchId +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", cityId=" + cityId +
                ", countryName='" + countryName + '\'' +
                ", countryId=" + countryId +
                ", provinceName='" + provinceName + '\'' +
                ", emsCompOri='" + emsCompOri + '\'' +
                ", taobaoOrderPrice=" + taobaoOrderPrice +
                ", postFee=" + postFee +
                ", orderSumPrice=" + orderSumPrice +
                ", totalFee=" + totalFee +
                ", adjustFee=" + adjustFee +
                ", partMjzDiscount=" + partMjzDiscount +
                ", divideOrderFee=" + divideOrderFee +
                ", payment=" + payment +
                ", price=" + price +
                ", discountFee=" + discountFee +
                ", logisticsType=" + logisticsType +
                '}';
    }
}