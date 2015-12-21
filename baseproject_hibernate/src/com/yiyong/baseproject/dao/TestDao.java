package com.yiyong.baseproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yiyong.baseproject.entity.Test;
import com.yiyong.framework.core.orm.Page;
import com.yiyong.framework.core.orm.hibernate.HibernateDao;
/**
 * 
 * @author zhoudong
 *
 */
@Repository
public class TestDao extends HibernateDao<Test, String>{
	/**
	 * 根据code查询
	 * @param code
	 * @return
	 */
	public Test findByCode(String code) {
		String hql = "from Test where code=?";
		return findUnique(hql, code);
	}
	/**
	 * 查询全部
	 * @return
	 */
	public List<Test> findAll() {
		String hql = "from Test";
		return find(hql);
	}
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public Object findByPage(Page<Test> page) {
		String hql = "from Test";
		return findPage(page, hql);
	}

}
