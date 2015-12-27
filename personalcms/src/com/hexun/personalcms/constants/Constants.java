package com.hexun.personalcms.constants;

import com.hexun.framework.core.utils.RespEnum;

/**
 * 常量
 * @author zhoudong
 *
 */
public enum Constants {
 	/**
 	 * 删除标记
 	 */
 	DEL_FLAG(1,"删除"),
 	/**
 	 * 未删除标记
 	 */
 	UN_DEL_FLAG(0,"未删除");
 	
 	private int code;
 	private String name;
 	
 	Constants(int code, String name){
 		this.code = code;
 		this.name = name;
 	}
 	
 	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}
