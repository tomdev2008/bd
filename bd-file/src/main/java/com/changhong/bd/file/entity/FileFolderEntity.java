package com.changhong.bd.file.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 文件目录实体
 */

@Entity
@Table(name="file_folder")
public class FileFolderEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 8137662460166953709L;

	@Column(name="ownerid")
	private String ownerId = "";
	
	@OneToMany
	@JoinColumn(name="parentid")
	private List<FileFolderEntity> children = new ArrayList<FileFolderEntity>();

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public List<FileFolderEntity> getChildren() {
		return children;
	}

	public void setChildren(List<FileFolderEntity> children) {
		this.children = children;
	}
	
	
	
}
