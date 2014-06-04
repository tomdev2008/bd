package com.changhong.bd.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月28日
 * @version 1.0
 * @description : 日期工具类
 */
public class DateUtils {

	/**
	 * 日期转字符串
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String dateToString(Date date, String formatter){
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}
}
