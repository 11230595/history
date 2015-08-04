package com.notepad.mapper;

import com.notepad.entity.FavoriteUrl;

public interface FavoriteUrlMapper {
    int deleteByPrimaryKey(String id);

    int insert(FavoriteUrl record);

    int insertSelective(FavoriteUrl record);

    FavoriteUrl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FavoriteUrl record);

    int updateByPrimaryKey(FavoriteUrl record);
}