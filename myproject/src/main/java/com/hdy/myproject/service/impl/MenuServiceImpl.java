package com.hdy.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdy.myproject.dao.MenuDao;
import com.hdy.myproject.entity.Menu;
import com.hdy.myproject.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
    private MenuDao menudao;
    
	@Override
	public List<Menu> selectMenuOne() {
		List list =menudao.selectMenuOne();
		// TODO Auto-generated method stub
		return menudao.selectMenuOne();
	}


	@Override
	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		menudao.addMenu(menu);
		return 0;
	}
	@Override
	public int deleteMenu(Integer id) {
		// TODO Auto-generated method stub
		return menudao.deleteMenu(id);
	}


	@Override
	public List<Menu> selectMenu(String pid) {
		// TODO Auto-generated method stub
		return menudao.selectMenu(pid);
	}


	@Override
	public List<Menu> selectMenupid() {
		// TODO Auto-generated method stub
		return menudao.selectMenupid();
	}

	

}
