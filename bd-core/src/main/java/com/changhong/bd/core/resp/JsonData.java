package com.changhong.bd.core.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : response不分页数据
 */
public class JsonData <T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1242257693814573992L;
	//总计
	private Long count;
	//数据
	private List<T> datas;
	
	public JsonData(Long count, List<T> datas){
		this.count = count;
		this.datas = datas;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}	
}
