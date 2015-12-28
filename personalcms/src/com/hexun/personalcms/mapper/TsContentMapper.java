package com.hexun.personalcms.mapper;

import java.util.List;
import java.util.Map;

import com.hexun.personalcms.entity.TsContent;

public interface TsContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsContent record);

    int insertSelective(TsContent record);

    TsContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsContent record);

    int updateByPrimaryKeyWithBLOBs(TsContent record);

    int updateByPrimaryKey(TsContent record);
    /**
     * 查询contentVO
     * @return
     */
	List<Map<String, Object>> findContentsVO();
}