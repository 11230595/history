package com.hexun.personalcms.mapper;

import com.hexun.personalcms.entity.TsContent;

public interface TsContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsContent record);

    int insertSelective(TsContent record);

    TsContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsContent record);

    int updateByPrimaryKeyWithBLOBs(TsContent record);

    int updateByPrimaryKey(TsContent record);
}