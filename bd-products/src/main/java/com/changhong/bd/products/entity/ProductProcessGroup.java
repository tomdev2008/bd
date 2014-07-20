package com.changhong.bd.products.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.changhong.bd.core.priority.Priority;

/**
 * @author QiYao
 * @date 2014年7月9日
 * @email yao.qi@changhong.com
 * @description 商品处理集合
 *
 */
@Entity
@Table(name="product_process_group")
public class ProductProcessGroup extends AbsTxNameEntity implements Priority{

	private static final long serialVersionUID = 8068256033152973816L;

	@Column(name="processtype")
	private Integer processType = 1; // 1，多选，2单选
	
	
	@Column(name="priority")
	private Integer priority = 1;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ProductProcess> processes = new ArrayList<ProductProcess>();

	/**
	 * @return the processType
	 */
	public Integer getProcessType() {
		return processType;
	}

	/**
	 * @param processType the processType to set
	 */
	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the processes
	 */
	public List<ProductProcess> getProcesses() {
		return processes;
	}

	/**
	 * @param processes the processes to set
	 */
	public void setProcesses(List<ProductProcess> processes) {
		this.processes = processes;
	}
	
	
	
}
