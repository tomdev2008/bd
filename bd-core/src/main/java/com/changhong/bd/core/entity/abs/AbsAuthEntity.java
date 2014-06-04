package com.changhong.bd.core.entity.abs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 权限 基类
 */
@MappedSuperclass
public abstract class AbsAuthEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -1581236201182025184L;

	@Column(name="code",length=256)
	private String code;//权限代码, 权限代码应该设计的得和rest full格式       object:crud:id 自定义格式  ud:object:desc

	public AbsAuthEntity(){
		
	}
	public AbsAuthEntity(AbsAuthEntity entity){
		super(entity);
		this.code = entity.getCode();
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}	
	
}
