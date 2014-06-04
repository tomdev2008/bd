package com.changhong.bd.core.domain;

import com.changhong.bd.core.entity.SysAuthMenuEntity;
import com.changhong.bd.core.entity.abs.AbsAuthEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description :菜单dto 
 */
public class SysAuthMenuDto extends AbsAuthEntity{

	private static final long serialVersionUID = -7786587525299079266L;

	public SysAuthMenuDto(){
		
	}
	public SysAuthMenuDto(SysAuthMenuEntity e){
		super(e);
		this.parentId = e.getCatalog().getId();
		this.parentName = e.getCatalog().getName();
		this.value = e.getValue();
		this.menuType = e.getMenuType();
	}
	private String parentId;
	private String parentName;
	private String value;
	private Integer menuType;

	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	
}
