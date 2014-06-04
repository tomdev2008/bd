package com.changhong.bd.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;


/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 系统组织架构
 */
@Entity
@Table(name = "bd_sys_organization")
public class SysOrganizationEntity extends AbsTxNameEntity {

	private static final long serialVersionUID = -6130071438265601818L;

	@Column(name="parentid", length=32)
	private String parentId = "0";//父级节点, 0 表示顶级节点
	
	@Column(name="principalid", length=32)
	private String principalId = "" ;//组织结构负责人
	
	@Column(name="orglevel")
	private Integer orgLevel = 0;//组织机构级别
	
	@Column(name="secretkey")
	private String secretKey = "";//密文  通过ID进行混淆的密文,暂时不启用

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
