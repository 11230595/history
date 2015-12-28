package com.hexun.personalcms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.personalcms.entity.TsReadCount;
import com.hexun.personalcms.mapper.TsReadCountMapper;
import com.hexun.personalcms.service.TsReadCountService;
/**
 * 阅读量
 * @author zhoudong
 *
 */
@Service
public class TsReadCountServiceImpl implements TsReadCountService {
	@Resource
	private TsReadCountMapper tsReadCountMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return tsReadCountMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TsReadCount record) {
		return tsReadCountMapper.insert(record);
	}

	@Override
	public int insertSelective(TsReadCount record) {
		return tsReadCountMapper.insertSelective(record);
	}

	@Override
	public TsReadCount selectByPrimaryKey(String id) {
		return tsReadCountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TsReadCount record) {
		return tsReadCountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TsReadCount record) {
		return tsReadCountMapper.updateByPrimaryKey(record);
	}


}
