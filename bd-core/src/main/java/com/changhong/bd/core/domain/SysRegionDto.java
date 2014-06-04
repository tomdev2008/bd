package com.changhong.bd.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;

import com.changhong.bd.core.entity.SysRegionEntity;
import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 地区数据对象, 使用Postcode进行排序
 */
public class SysRegionDto extends AbsTxNameEntity 
	implements Comparable<SysRegionDto>{

	private static final long serialVersionUID = -5333882036089515813L;

	// 邮政编码
	private String postcode;

	// 子节点
	@OneToMany
	private List<SysRegionDto> children = new ArrayList<SysRegionDto>();

	// 地区的级别 continent nation province/state city town
	private String regionLevel;

	public SysRegionDto(){
		
	}
	public SysRegionDto(SysRegionEntity entity){
		super(entity);
		this.postcode = entity.getPostcode();
		this.regionLevel = entity.getRegionLevel();
		
		Set<SysRegionEntity> sets = entity.getChildren();
		if(null!=sets){
			for(SysRegionEntity reg : sets){
				SysRegionDto srd = new SysRegionDto(reg);
				this.children.add(srd);
			}
		}
		
		Collections.sort(this.children);
	}

	@Override
	public int compareTo(SysRegionDto o) {
		return this.postcode.compareTo(o.getPostcode());
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public List<SysRegionDto> getChildren() {
		return children;
	}

	public void setChildren(List<SysRegionDto> children) {
		this.children = children;
	}

	public String getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(String regionLevel) {
		this.regionLevel = regionLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
