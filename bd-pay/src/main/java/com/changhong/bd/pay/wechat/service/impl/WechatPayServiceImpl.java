package com.changhong.bd.pay.wechat.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.utils.DateUtils;
import com.changhong.bd.pay.dao.api.PayRequestDao;
import com.changhong.bd.pay.domain.PayRequestDto;
import com.changhong.bd.pay.entity.PayRequestEntity;
import com.changhong.bd.pay.wechat.service.api.WechatPayService;
import com.changhong.bd.pay.wechat.utils.SDKRuntimeException;
import com.changhong.bd.pay.wechat.utils.WechatUtils;
import com.changhong.bd.pay.wechat.utils.WxPayHelper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 
 */
@Service("wechatPayService")
public class WechatPayServiceImpl implements WechatPayService{

	@Autowired
	private PayRequestDao payRequestDao;
	
	@Override
	public PayRequestDto addPayRequest(PayRequestEntity entity) {
		PayRequestDto dto = this.process(entity);
		return dto;
	}
	
	public PayRequestDto process(PayRequestEntity entity){
		entity.setBankType("WX");
		DateTime dt = new DateTime(new Date());
		
		Date start = dt.toDate();
		dt.plusHours(2);
		Date end = dt.toDate();

		entity.setTimeStart(DateUtils.dateToString(start, "yyyyMMddhhmmss"));
		entity.setTimeExpire(DateUtils.dateToString(end, "yyyyMMddhhmmss"));
		
		Long totalFee = entity.getProductFee() + entity.getTransportFee();
		entity.setTotalFee(totalFee);
		
		this.payRequestDao.saveOrUpdate(entity);
		
		PayRequestDto dto = new PayRequestDto();
		try {
			BeanUtils.copyProperties(dto, entity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		this.payBuild(dto);
		return dto;
		
	}
	private void payBuild(PayRequestDto dto) {
		WxPayHelper wxPayHelper = new WxPayHelper();
		
		String appId = WechatUtils.getAppId();
		String appKey = WechatUtils.getPaySignKey();
		String partnerId = WechatUtils.getPartnerId();
		String partnerKey = WechatUtils.getPartnerKey();
		String signType = "sha1";
		String notifyUrl = WechatUtils.getNotifyUrl();
		
		wxPayHelper.SetAppId(appId);
		wxPayHelper.SetAppKey(appKey);
		wxPayHelper.SetPartnerKey(partnerKey);
		wxPayHelper.SetSignType(signType);
		
		//设置请求package信息
		wxPayHelper.SetParameter("bank_type", dto.getBankType());
		wxPayHelper.SetParameter("body", dto.getBody());
		wxPayHelper.SetParameter("partner", partnerId);
		wxPayHelper.SetParameter("out_trade_no", dto.getId());
		wxPayHelper.SetParameter("total_fee", String.valueOf(dto.getTotalFee()));
		wxPayHelper.SetParameter("fee_type", String.valueOf(dto.getFeeType()));
		wxPayHelper.SetParameter("notify_url", notifyUrl);
		wxPayHelper.SetParameter("spbill_create_ip", dto.getSpBillCreateIp());
		wxPayHelper.SetParameter("input_charset", dto.getInputCharset());
		
		String jsPackageString;
		try {
			jsPackageString = wxPayHelper.CreateBizPackage();
			dto.setJsPackageString(jsPackageString );
		} catch (SDKRuntimeException e) {
			e.printStackTrace();
		}

	}

	public List<PayRequestDto> transfer(List<PayRequestEntity> list){
		List<PayRequestDto> dtos = new ArrayList<PayRequestDto>();
		
		if(null!=list && list.size()>0){
			for(PayRequestEntity e:list){
				dtos.add(this.transfer(e));
			}
		}
		return dtos;
	}
	public PayRequestDto transfer(PayRequestEntity entity){
		PayRequestDto dto = new PayRequestDto();
		try {
			BeanUtils.copyProperties(dto, entity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public PayRequestDto addPayRequest(String payId) {
		PayRequestEntity e = this.payRequestDao.query(payId);
		PayRequestDto dto = this.process(e);
		return dto;
	}

}
