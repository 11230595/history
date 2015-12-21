package com.yiyong.framework.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {
	public NumberUtils() {
		super();
	}

	/**
	 * 格式化
	 * 
	 * @param dou
	 * @param format
	 * @return
	 */
	public static Double format(Double dou, String format) {
		DecimalFormat df = new DecimalFormat(format);
		return Double.parseDouble(df.format(dou));
	}

	/**
	 * 默认格式化(保留两位小数-四舍六入五奇偶)
	 * 
	 * @param dou
	 * @return Double
	 */
	public static Double format(Double dou) {
		DecimalFormat df = new DecimalFormat("############0.##");
		return Double.parseDouble(df.format(dou));
	}

	/**
	 * 转换一个数字为四舍五入，并保留指定位精度
	 * @param bigDecimal
	 * @param scale 精度位数
	 * @return
	 */
	public static BigDecimal format(BigDecimal bigDecimal, int scale) {
		if (bigDecimal == null) {
			return new BigDecimal(0);
		}
		return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
	}
}
