package com.changhong.bd.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 数据元素集合
 */
@Entity
@Table(name="data_data_ele_group")
public class DataElementGroupEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -2371640329588804327L;

	//归属仓库
	@ManyToOne
	@JoinColumn(name="repid")
	private RepositoryEntity rep;
	
	//处理语句  就是sql, 长文本字段
	@Column(name="processlanguage")
	private String processLanguage;
	
	@OneToMany(mappedBy="group",cascade=CascadeType.ALL)
	private List<DataElementEntity> dataElements;

	public RepositoryEntity getRep() {
		return rep;
	}

	public void setRep(RepositoryEntity rep) {
		this.rep = rep;
	}

	public String getProcessLanguage() {
		return processLanguage;
	}

	public void setProcessLanguage(String processLanguage) {
		this.processLanguage = processLanguage;
	}

	public List<DataElementEntity> getDataElements() {
		return dataElements;
	}

	public void setDataElements(List<DataElementEntity> dataElements) {
		this.dataElements = dataElements;
	}
	
}
