package com.cike.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;
/**
 * 字符串转换为日期
 * @author CIKE
 *
 */
public class MyDateConverter implements Converter {
	/**
	 * 字符串转为日志
	 */
	@Override
	public Object convert(Class c, Object obj) {
		String s = (String) obj;
		// 把字符串转换为日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(s);
		} catch (ParseException e) {
			throw new RuntimeException("转换日期错误！");
		}
		return d;
	}

}
