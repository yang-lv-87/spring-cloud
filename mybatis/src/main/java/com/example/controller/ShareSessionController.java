package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShareSessionController {

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public Map<String, Object> showSession(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();  
		session.setAttribute("request Url", request.getRequestURL());  
		map.put("sessionId", session.getId());  
        map.put("request Url 8081", request.getRequestURL());  
        map.put("name", session.getAttribute("name"));  
        return map;  
	}
	
	@RequestMapping(value = "set", method = RequestMethod.GET)
	public Map<String, Object> setSession(String name, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		session.setAttribute("name", name);
		map.put("name", name);  
        return map;  
	}
}
