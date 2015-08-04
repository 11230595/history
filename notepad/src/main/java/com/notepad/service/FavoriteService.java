package com.notepad.service;

import java.util.List;

import com.notepad.entity.Favorite;

/**
 * 收藏夹
 * @author zhoudong
 *
 */
public interface FavoriteService {
	
	int deleteByPrimaryKey(String id);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
    /**
     * 查询list
     * @param userCode
     * @return
     */
	List<Favorite> findFavroites(String userCode);
}
