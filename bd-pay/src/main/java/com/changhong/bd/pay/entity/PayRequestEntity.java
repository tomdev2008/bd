package com.changhong.bd.pay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 支付请求实体
 * 
 * status 状态 1表明是创建了的订单，10表示付款成功的订单
 */
@Entity
@Table(name="pay_request")
public class PayRequestEntity extends AbsTxNameEntity {

	private static final long serialVersionUID = -2872253530737825811L;

	//银行通道类型  ， 微信：WX
	@Column(name="banktype")
	private String bankType;
	
	//商品描述 128
	@Column(name="cbody")
	private String body;
	
	//附加数据 128, 附加数据原样返回
	@Column(name="cattach")
	private String attach;
	
	//订单总金额，单位：分
	@Column(name="totalfee")
	private Long totalFee;
	
	//币种，暂时支持1
	@Column(name="feetype")
	private Integer feeType = 1;
	
	//用户的IPV4 IP地址
	@Column(name="spbillcreateip")
	private String spBillCreateIp;
	
	//开始时间 yyyyMMddHHmmss
	@Column(name="timestart")
	private String timeStart;
	
	//失效时间yyyyMMddHHmmss
	@Column(name="timeexpire")
	private String timeExpire;
	
	//物流费用
	@Column(name="transportfee")
	private Long transportFee = 0L;
	
	//商品费用
	@Column(name="productfee")
	private Long productFee = 0L;
	
	//商品标记，预留给优惠劵
	@Column(name="goodstag")
	private String goodsTag;
	
	//编码格式
	@Column(name="inputcharset")
	private String inputCharset = "UTF-8";

	//订单创建时间
	@Column(name="createtime")
	private Date createTime = new Date();
	
	//付款成功的时间
	@Column(name="finishtime")
	private Date finishTime = new Date();
	
	public PayRequestEntity(
			String name,
			String bankType,
			String body,
			String attach,
			Long totalFee,
			Integer feeType,
			String spBillCreateIp,
			String timeStart,
			String timeExpire,
			Long transportFee,
			Long productFee,
			String goodsTag) {
		super();
		this.setName(name);
		
		this.bankType = bankType;
		this.body = body;
		this.attach = attach;
		this.totalFee = totalFee;
		this.feeType = feeType;
		this.spBillCreateIp = spBillCreateIp;
		this.timeStart = timeStart;
		this.timeExpire = timeExpire;
		this.transportFee = transportFee;
		this.productFee = productFee;
		this.goodsTag = goodsTag;
	}
	public PayRequestEntity(){
		
	}
	

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
	
	
}
