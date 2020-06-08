package com.hdy.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdy.myproject.dao.AreaDao;
import com.hdy.myproject.entity.Area;
import com.hdy.myproject.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
   private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		List<Area> areaList = areaDao.selectArea();
		System.out.println(areaList);
		
		return areaList;
	}
	
}
