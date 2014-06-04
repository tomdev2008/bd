package com.changhong.bd.core.priority;

import java.util.Comparator;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 优先级对比器
 */
public class PriorityComparator< T extends Priority> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		Integer a = o1.getPriority();
		Integer b = o2.getPriority();
		return a-b;
	}


}
