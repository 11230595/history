package com.notepad.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.notepad.entity.Favorite;
import com.notepad.mapper.FavoriteMapper;
import com.notepad.service.FavoriteService;
/**
 * 收藏夹
 * @author zhoudong
 *
 */
@Service
public class FavoriteServiceImpl implements FavoriteService{
	@Resource
	private FavoriteMapper favoriteMapper;
	
	/**
	 * 删除
	 */
	public int deleteByPrimaryKey(String id) {
		return favoriteMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 保存
	 */
	public int insert(Favorite record) {
		return favoriteMapper.insert(record);
	}
	/**
	 * 保存
	 */
	public int insertSelective(Favorite record) {
		return favoriteMapper.insertSelective(record);
	}
	/**
	 * 根据ID查询
	 */
	public Favorite selectByPrimaryKey(String id) {
		return favoriteMapper.selectByPrimaryKey(id);
	}
	/**
	 * 更新
	 */
	public int updateByPrimaryKeySelective(Favorite record) {
		return favoriteMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 更新
	 */
	public int updateByPrimaryKey(Favorite record) {
		return favoriteMapper.updateByPrimaryKey(record);
	}
	/**
	 * 根据用户名 查询全部收藏夹
	 */
	public List<Favorite> findFavroites(String userCode) {
		return favoriteMapper.findFavroites(userCode);
	}

}
