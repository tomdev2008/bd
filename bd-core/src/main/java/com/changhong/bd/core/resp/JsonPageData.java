package com.changhong.bd.core.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 分页response数据
 */
public class JsonPageData<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1242257693814573992L;
	//页码
	private Integer pageNo;
	//页大小
	private Integer pageSize;
	//总计
	private Long count;
	//数据
	private List<T> datas;
	
	public JsonPageData(Integer pageNo, Integer pageSize, Long count, List<T> datas){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.datas = datas;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
