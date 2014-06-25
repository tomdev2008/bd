package com.changhong.bd.social.service.api;

import java.util.List;

import com.changhong.bd.social.entity.SocialBindEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 
 */
public interface SocialService {

	/**
	 * 通过绑定类型，openid查询用户真实的信息
	 * @param type ${link : com.changhong.bd.social.utils.SocialTypeUtils}
	 * @param openId
	 * @return
	 */
	public List<SocialBindEntity> queryByOpenId(String type, String openId);
	
	/**
	 * 通过usre id 查询绑定信息
	 * @param type
	 * @param userId
	 * @return
	 */
	public List<SocialBindEntity> queryByUserId(String type, String userId);
	
	/**
	 * 创建绑定连接
	 * @param userId
	 * @param type ${link : com.changhong.bd.social.utils.SocialTypeUtils}
	 * @param openId
	 */
	public SocialBindEntity addLink(String userId, String type, String openId);
	
	/**
	 * 删除绑定信息
	 * @param id
	 */
	public void deleteLink(String id);
	/**
	 * 删除绑定信息
	 * @param socialBind
	 */
	public void deleteLink(SocialBindEntity socialBind);
}
