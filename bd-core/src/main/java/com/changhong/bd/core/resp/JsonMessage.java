package com.changhong.bd.core.resp;

import java.io.Serializable;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : ajax返回的message信息
 */
public class JsonMessage implements Serializable{

	private static final long serialVersionUID = -1882833679184634855L;
	
	public static final Integer ERROR = 510;
	/**
	 * 返回状态，前端Ajax会处理510的正常返回为错误
	 * 状态默认为200
	 */
	private Integer status = 200;
	/**
	 * 文本信息
	 */
	private String message;
	
	public JsonMessage(){
		
	}
	public JsonMessage(Integer status, String message){
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
