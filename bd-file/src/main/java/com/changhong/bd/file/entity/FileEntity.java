package com.changhong.bd.file.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 文件实体
 */
@Entity
@Table(name="file_file")
public class FileEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 1192703775993324172L;

	//所有者ID
	@Column(name="ownerid")
	private String ownerId = "";
	//文件类型
	@Column(name="type")
	private String type = "";
	//后缀
	@Column(name="suffix")
	private String suffix = "";
	//文件大小
	@Column(name="size")
	private Long size = 0L;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	
}
