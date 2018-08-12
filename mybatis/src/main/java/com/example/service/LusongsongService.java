package com.example.service;

import java.util.List;

import com.mybatis.model.Lusongsong;

public interface LusongsongService {
	List<Lusongsong> getList(int pageNum, int pageSize);
	void save(Lusongsong lusongsong);
}
