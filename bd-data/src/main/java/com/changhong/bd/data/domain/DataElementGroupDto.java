package com.changhong.bd.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.modelmapper.ModelMapper;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.changhong.bd.data.entity.DataElementEntity;
import com.changhong.bd.data.entity.DataElementGroupEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 
 */
public class DataElementGroupDto  extends AbsTxNameEntity{

	private static final long serialVersionUID = 7573161410161294857L;

	private static ModelMapper mm = new ModelMapper();
	//归属仓库
	@ManyToOne
	@JoinColumn(name="repid")
	private RepositoryDto rep = null;
	
	//处理语句  就是sql, 长文本字段
	@Column(name="processlanguage")
	private String processLanguage = "";
	
	@OneToMany
	@JoinColumn(name="groupid")
	private List<DataElementDto> dataElements = new ArrayList<DataElementDto>();

	public DataElementGroupDto(){
		
	}
	public DataElementGroupDto(DataElementGroupEntity e){
		super(e);
		this.rep = new RepositoryDto(e.getRep());
		this.processLanguage = e.getProcessLanguage();
		List<DataElementEntity> list = e.getDataElements();
		if(null!=list){
			for(DataElementEntity de : list){
				this.dataElements.add(mm.map(de, DataElementDto.class));
			}
		}
	}

	public RepositoryDto getRep() {
		return rep;
	}
	public void setRep(RepositoryDto rep) {
		this.rep = rep;
	}
	public String getProcessLanguage() {
		return processLanguage;
	}
	public void setProcessLanguage(String processLanguage) {
		this.processLanguage = processLanguage;
	}
	public List<DataElementDto> getDataElements() {
		return dataElements;
	}
	public void setDataElements(List<DataElementDto> dataElements) {
		this.dataElements = dataElements;
	}
	
}