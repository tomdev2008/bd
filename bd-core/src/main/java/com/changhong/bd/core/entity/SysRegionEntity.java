package com.changhong.bd.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @param <SysReginEntity>
 * @description : 区域对象 
 */
@Entity
@Table(name="bd_sys_region")
public class SysRegionEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 308761534669076195L;

	//邮政编码
	@Column(name="postcode")
	private String postcode = "";
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parentid")
	private SysRegionEntity parent;
	
	//子节点
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="parentid")
	private Set<SysRegionEntity> children = new HashSet<SysRegionEntity>();

	//地区的级别  continent nation province/state city town
	@Column(name="regionlevel")
	private String regionLevel = "city";
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Set<SysRegionEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<SysRegionEntity> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(String regionLevel) {
		this.regionLevel = regionLevel;
	}

	public SysRegionEntity getParent() {
		return parent;
	}

	public void setParent(SysRegionEntity parent) {
		this.parent = parent;
	}
	
	
}
