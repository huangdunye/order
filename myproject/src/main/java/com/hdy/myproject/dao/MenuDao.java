package com.hdy.myproject.dao;

import java.util.List;

import com.hdy.myproject.entity.Menu;

public interface MenuDao {
	//一级菜单列表
  public List<Menu> selectMenuOne();
  //二级菜单列表
  public List<Menu> selectMenu(String pid);
  //pid等于null
  public List<Menu> selectMenupid();
  //添加菜单
  public int addMenu(Menu menu);
  //删除菜单
  public int deleteMenu(Integer id);

  
  
  

}
