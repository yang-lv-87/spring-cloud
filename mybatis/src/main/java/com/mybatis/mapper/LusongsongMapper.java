package com.mybatis.mapper;

import java.util.List;

import com.mybatis.model.Lusongsong;

public interface LusongsongMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lusongsong record);

    int insertSelective(Lusongsong record);

    Lusongsong selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lusongsong record);

    int updateByPrimaryKey(Lusongsong record);
    
    List<Lusongsong> getList();
}