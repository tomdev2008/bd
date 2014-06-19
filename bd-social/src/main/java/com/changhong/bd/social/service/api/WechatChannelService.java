package com.changhong.bd.social.service.api;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.entity.WechatChannelEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 微信频道 服务 接口
 */
public interface WechatChannelService {

	/**
	 * 查询用户当前所在的频道
	 * @param openId
	 * @return null，当前不存在任何频道
	 */
	public WechatChannelDto queryCurrent(String openId);

	/**
	 * 新增频道信息
	 * @param entity
	 * @return
	 */
	public WechatChannelDto add(WechatChannelEntity entity);

	/**
	 * 删除指定ID的状态channel
	 * @param id
	 */
	public void delete(String id);
}
