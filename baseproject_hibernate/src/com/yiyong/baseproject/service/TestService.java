package com.yiyong.baseproject.service;

import java.util.List;

import com.yiyong.baseproject.entity.Test;
import com.yiyong.framework.core.orm.Page;
/**
 * 
 * @author zhoudong
 *
 */
public interface TestService {
	/**
	 * 保存
	 * @param test
	 */
	void save(Test test);
	/**
	 * 根据code查询实体
	 * @param code
	 * @return
	 */
	Test findByCode(String code);
	/**
	 * 查询全部
	 * @return
	 */
	List<Test> findAll();
	/**
	 * 分页查询
	 * @param page
	 */
	void findByPage(Page<Test> page);

}
