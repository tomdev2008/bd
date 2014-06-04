package com.changhong.bd.social.plugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月18日
 * @version 1.0
 * @description : 实现了排序算法
 */
public abstract class AbsWechatProcessPlugin implements WechatProcessPlugin {

	@Override
	public int compareTo(WechatProcessPlugin o) {
		if(this.getPriority() > o.getPriority()){
			return 1;
		}else{
			return 0;
		}
	}

}
