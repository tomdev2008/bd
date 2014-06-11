package com.changhong.bd.data.domain;

import org.modelmapper.ModelMapper;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.changhong.bd.data.entity.DataReporterEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 
 */
public class DataReporterDto extends AbsTxNameEntity {

	private static final long serialVersionUID = 765150569959360685L;

	private String uiconfig = "";
	private String dataconfig = "";

	private String userId = "";
	private String userName = "";
	private String shareId = "";
	
	public DataReporterDto(){
		super();
	}
	public DataReporterDto(DataReporterEntity e){
		ModelMapper mm = new ModelMapper();
		mm.map(e, this);
	}
	public String getUiconfig() {
		return uiconfig;
	}
	public void setUiconfig(String uiconfig) {
		this.uiconfig = uiconfig;
	}
	public String getDataconfig() {
		return dataconfig;
	}
	public void setDataconfig(String dataconfig) {
		this.dataconfig = dataconfig;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	
	
}
