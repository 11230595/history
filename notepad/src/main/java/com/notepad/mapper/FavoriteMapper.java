package com.notepad.mapper;

import java.util.List;

import com.notepad.entity.Favorite;

public interface FavoriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
    /**
     * 根据userCode查询全部收藏夹
     * @param userCode
     * @return
     */
	List<Favorite> findFavroites(String userCode);
}