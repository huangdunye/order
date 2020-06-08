package com.hdy.myproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdy.myproject.service.AreaService;
@Controller
@RequestMapping("/area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	@RequestMapping("/selectarea" )
   public String selectArea() {
	
	return "index";
	   
   }
	@RequestMapping("/jg" )
	   public String jg() {
		
		return "index2";
		   
	   }
}
