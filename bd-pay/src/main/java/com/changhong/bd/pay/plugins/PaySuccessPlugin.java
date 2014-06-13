package com.changhong.bd.pay.plugins;

import com.changhong.bd.core.priority.Priority;
import com.changhong.bd.pay.domain.PayRequestDto;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 支付成功接口。
 * 只要实现该接口，在服务器收到确认的支付结果的时候，将回调该接口的实现类。
 * 实现类数量不做限制，顺序调用，注意优先级接口的排序功能
 */
public interface PaySuccessPlugin extends Priority {

	/**
	 * 收到正确的支付结果的dto
	 * @param dto
	 */
	public void process(PayRequestDto dto);
}
