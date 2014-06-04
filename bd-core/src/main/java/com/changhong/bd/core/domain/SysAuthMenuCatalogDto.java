package com.changhong.bd.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.changhong.bd.core.entity.SysAuthMenuCatalogEntity;
import com.changhong.bd.core.entity.SysAuthMenuEntity;
import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 菜单目录 dto
 */
public class SysAuthMenuCatalogDto extends AbsTxNameEntity{

	private static final long serialVersionUID = 8875920046251078829L;

	private List<SysAuthMenuCatalogDto> children = new ArrayList<SysAuthMenuCatalogDto>();
	private List<SysAuthMenuDto> menus = new ArrayList<SysAuthMenuDto>();
	public SysAuthMenuCatalogDto(){
		
	}
	/**
	 * 
	 * @param e
	 * @param initChildren 是否初始化子节点
	 * @param initMenu 是否初始化菜单信息
	 */
	public SysAuthMenuCatalogDto(SysAuthMenuCatalogEntity e, boolean initChildren, boolean initMenu){
		super(e);
		if(initChildren){
			Set<SysAuthMenuCatalogEntity> ec = e.getChildren();
			if(ec!=null && ec.size()>0){
				for(SysAuthMenuCatalogEntity i:ec){
					this.children.add(new SysAuthMenuCatalogDto(i, initChildren, initMenu));
				}
			}
		}
		if(initMenu){
			Set<SysAuthMenuEntity> sm = e.getMenus();
			if(null!=sm && sm.size()>0){
				for(SysAuthMenuEntity i : sm){
					this.menus.add(new SysAuthMenuDto(i));
				}
			}
		}
	}
	public List<SysAuthMenuCatalogDto> getChildren() {
		return children;
	}
	public void setChildren(List<SysAuthMenuCatalogDto> children) {
		this.children = children;
	}
	public List<SysAuthMenuDto> getMenus() {
		return menus;
	}
	public void setMenus(List<SysAuthMenuDto> menus) {
		this.menus = menus;
	}
	
}
