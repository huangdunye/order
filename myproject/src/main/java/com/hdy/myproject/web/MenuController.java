package com.hdy.myproject.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdy.myproject.entity.Menu;
import com.hdy.myproject.service.MenuService;

@Controller
@RequestMapping(value = "/menu", method = { RequestMethod.GET,
		RequestMethod.POST })
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public String menuList() {
		return "menu/menuList";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "menu/addMenu";
	}
	@RequestMapping(value = "/getmenuList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getmenuList() {
		
		Map<String,Object> map=new HashMap<String, Object>();
		 List<Menu> list=new ArrayList<Menu>();
		
		 list= menuService.selectMenuOne(); 
			 map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = "/addmenu", method = RequestMethod.POST)
	@ResponseBody
	public boolean addmenu(@RequestParam Map<String, Object>addmenu) {
		boolean success=true;
		Menu menu=new Menu();
		try {
		String pid=	addmenu.get("pid").toString() == null ? null:addmenu.get("pid").toString();
		menu.setMenuname(addmenu.get("menu_name").toString());
		menu.setCreatetime(new Date());
		menu.setLevel("1");
		if(""!=pid) {
			menu.setPid(pid);
			menu.setLevel("2");
		}
		
		int a=menuService.addMenu(menu);
		System.out.println(menu.getId()+">>>>>");
		} catch (Exception e) {
			 success=false;
			// TODO: handle exception
		}
		return success;
	}
	@RequestMapping(value = "/deletelist", method = RequestMethod.GET)

	public String deletelist(@RequestParam Integer id,@RequestParam String pid) {
		try {
			if(id!=null&"null".equals(pid)) {
			int a= menuService.deleteMenu(id);
			}
			if(!"null".equals(pid)) {
	List<Menu> list=	menuService.selectMenu(pid);
	for (int i = 0; i < list.size(); i++) {
		
	int b=menuService.deleteMenu(list.get(i).getId());
	}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/menu/menuList";
	}
}
