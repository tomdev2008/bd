package com.changhong.bd.core.entity.abs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : ID
 */
@MappedSuperclass
public class AbsEntity implements Serializable{

	private static final long serialVersionUID = -4420073803561413495L;

	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name = "id", insertable = true, updatable = false, nullable = false)
	private String id;//uuid

	public AbsEntity(){
		
	}
	public AbsEntity(AbsEntity e){
		this.id = e.getId();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
