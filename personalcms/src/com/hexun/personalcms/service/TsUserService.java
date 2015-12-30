package com.hexun.personalcms.service;

import java.util.Map;

import com.hexun.framework.core.page.Page;
import com.hexun.personalcms.entity.TsUser;

public interface TsUserService {
	int deleteByPrimaryKey(String id);

    int insert(TsUser record);

    int insertSelective(TsUser record);

    TsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsUser record);

    int updateByPrimaryKey(TsUser record);

	TsUser login(String userCode, String password);

	/**
	 * 分页查询
	 * @param sqlId    xml 中的sqlID
	 * @param paramMap	参数
	 * @param pageNo	当前页
	 * @param pageSize	每一页的长度
	 * @return
	 */
	Page<TsUser> findUserByPage(String sqlId, Map<String, Object> paramMap,
			int pageNo, int pageSize);
}
