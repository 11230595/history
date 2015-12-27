package com.hexun.personalcms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.personalcms.entity.TsContent;
import com.hexun.personalcms.mapper.TsContentMapper;
import com.hexun.personalcms.service.TsContentService;

@Service
public class TsContentServiceImpl implements TsContentService{
	@Resource
	private TsContentMapper tsContentMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return tsContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TsContent record) {
		return tsContentMapper.insert(record);
	}

	@Override
	public int insertSelective(TsContent record) {
		return tsContentMapper.insertSelective(record);
	}

	@Override
	public TsContent selectByPrimaryKey(String id) {
		return tsContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TsContent record) {
		return tsContentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(TsContent record) {
		return tsContentMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(TsContent record) {
		return tsContentMapper.updateByPrimaryKey(record);
	}

}
