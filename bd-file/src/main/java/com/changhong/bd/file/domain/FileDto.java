package com.changhong.bd.file.domain;

import java.io.InputStream;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.changhong.bd.file.entity.FileEntity;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description :
 */
public class FileDto extends AbsTxNameEntity {
	private static final long serialVersionUID = 6736773278281211375L;
	//所有者ID
	private String ownerId = "";
	// 文件类型
	private String type = "";
	// 后缀
	private String suffix = "";
	// 文件大小
	private Long size = 0L;
	//文件
	private InputStream inputStream = null;

	public FileDto(){
		
	}
	public FileDto(FileEntity e, InputStream is){
		super(e);
		this.init(e);
		this.inputStream = is;
	}
	public FileDto(FileEntity e){
		super(e);
		this.init(e);
	}
	public void init(FileEntity e){
		this.type = e.getType();
		this.suffix = e.getSuffix();
		this.size = e.getSize();
		this.ownerId = e.getOwnerId();
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

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
