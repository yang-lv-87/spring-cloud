package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.LusongsongService;
import com.mybatis.model.Lusongsong;

@Controller
public class LusongsongController {
	@Autowired
	private LusongsongService lusongsongService;
	
	@RequestMapping(value = "list/{pageNum}/{pageSize}", method= {RequestMethod.GET})
	public String getList(Model model, @PathVariable int pageNum, @PathVariable int pageSize) {
		List<Lusongsong> list = lusongsongService.getList(pageNum, pageSize);
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	
	@RequestMapping("/save")
	public String save(Lusongsong lusongsong) {
		lusongsongService.save(lusongsong);
		return "redirect:list/1/10";
	}
}
