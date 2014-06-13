package com.changhong.bd.pay.domain;

import java.util.Date;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 
 */
public class PayRequestDto extends AbsTxNameEntity{
	
	private static final long serialVersionUID = -8467013542438513594L;

	private String bankType;
	
	private String body;
	
	private String attach;
	
	private Long totalFee;
	
	private Integer feeType = 1;
	
	private String spBillCreateIp;
	
	private String timeStart;
	
	private String timeExpire;
	
	private Long transportFee = 0L;
	
	private Long productFee = 0L;
	
	private String goodsTag;
	
	private String inputCharset = "UTF-8";
	
	private Date createTime;
	
	private Date finishTime;
	//生成的js支付package包
	private String JsPackageString;
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public Long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	public Integer getFeeType() {
		return feeType;
	}
	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
	public String getSpBillCreateIp() {
		return spBillCreateIp;
	}
	public void setSpBillCreateIp(String spBillCreateIp) {
		this.spBillCreateIp = spBillCreateIp;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeExpire() {
		return timeExpire;
	}
	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}
	public Long getTransportFee() {
		return transportFee;
	}
	public void setTransportFee(Long transportFee) {
		this.transportFee = transportFee;
	}
	public Long getProductFee() {
		return productFee;
	}
	public void setProductFee(Long productFee) {
		this.productFee = productFee;
	}
	public String getGoodsTag() {
		return goodsTag;
	}
	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}
	public String getInputCharset() {
		return inputCharset;
	}
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getJsPackageString() {
		return JsPackageString;
	}
	public void setJsPackageString(String jsPackageString) {
		JsPackageString = jsPackageString;
	}
	
	
}
