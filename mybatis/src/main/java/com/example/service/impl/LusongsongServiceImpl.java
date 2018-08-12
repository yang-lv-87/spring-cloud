package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.LusongsongService;
import com.github.pagehelper.PageHelper;
import com.mybatis.mapper.LusongsongMapper;
import com.mybatis.model.Lusongsong;

@Service("lusongsongService")
public class LusongsongServiceImpl implements LusongsongService {
	@Autowired
	private LusongsongMapper lusongsongDao;

	@Override
	public List<Lusongsong> getList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Lusongsong> list = lusongsongDao.getList();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void save(Lusongsong lusongsong) {
		lusongsongDao.insert(lusongsong);
	}

}
