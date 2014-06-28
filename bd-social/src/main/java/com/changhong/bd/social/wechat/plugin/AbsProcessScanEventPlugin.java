package com.changhong.bd.social.wechat.plugin;
/**
 * abs sacn event processer
 * @author Sunrui
 * @date 2014年6月28日
 */
public abstract class AbsProcessScanEventPlugin
	implements ProcessScanEventPlugin{

	@Override
	public int compareTo(ProcessScanEventPlugin o) {
		return this.getPriority() - o.getPriority();
	}

}
