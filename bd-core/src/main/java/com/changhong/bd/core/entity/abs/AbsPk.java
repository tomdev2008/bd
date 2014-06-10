package com.changhong.bd.core.entity.abs;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月10日
 * @version 1.0
 * @description : 联合主键Pk基类
 */
public abstract class AbsPk implements Serializable{

	private static final long serialVersionUID = -287854359017043469L;
	
	protected abstract List<Object> getPkField();

	@Override
	public int hashCode() {
		List<Object> listP = this.getPkField();
		HashCodeBuilder builder = new HashCodeBuilder();
		
		for(Object obj : listP){
			builder.append(obj);
		}
		return builder.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		AbsPk bpk = (AbsPk)obj;
		
		List<Object> listP = this.getPkField();
		List<Object> listC = bpk.getPkField();
		
		EqualsBuilder builder = new EqualsBuilder();
		for(int i=0;i<listP.size();i++){
			builder.append(listP.get(i), listC.get(i));
		}
		
		return builder.isEquals();
	}
}
