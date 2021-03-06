package com.hexun.personalcms.service;

import com.hexun.personalcms.entity.TsReadCount;

public interface TsReadCountService {
    int deleteByPrimaryKey(String id);

    int insert(TsReadCount record);

    int insertSelective(TsReadCount record);

    TsReadCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsReadCount record);

    int updateByPrimaryKey(TsReadCount record);
    /**
     * 根据内容ID查询
     * @param contentId 
     * @return
     */
	TsReadCount findTsReadCountByContentId(String contentId);
}
