package com.hdy.myproject;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdy.myproject.dao.AreaDao;
import com.hdy.myproject.entity.Area;
import com.hdy.myproject.service.AreaService;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Autowired
	private AreaDao areaDao;
	@Test
	public void testBQueryArea() throws Exception {
		
		//List<Area> areaList = areaService.getAreaList();
		//System.out.println(areaList);
		areaDao.selectArea();
	System.out.println(areaDao.selectArea()+"??????????");
		
	}
}
