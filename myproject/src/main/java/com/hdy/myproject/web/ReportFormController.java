package com.hdy.myproject.web;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdy.myproject.entity.Menu;
import com.hdy.myproject.service.MenuService;
import com.hdy.myproject.util.ExcelUtil;
@Controller
@RequestMapping(value = "/report")
public class ReportFormController   {
	@Autowired
	private MenuService menuService;
	/**
	     * 导出报表
	     * @return
	     */
	    @RequestMapping(value = "/export")
	    @ResponseBody
	    public void export(HttpServletRequest request,HttpServletResponse response)  {
	           //获取数据
	           List<Menu> list =menuService.selectMenuOne();

	           //excel标题
	String[] title = {"名称","性别","年龄","学校","班级"};
	
	//excel文件名
	 String fileName = "学生信息表"+System.currentTimeMillis()+".xls";
	
	//sheet名
	String sheetName = "学生信息表";
	
	String[][] content = null;
	for (int i = 0; i < list.size(); i++) {
		            content[i] = new String[title.length];
		            Menu obj = list.get(i);
		            content[i][0] = obj.getId().toString();
		            content[i][1] = obj.getMenuname().toString();
		            content[i][2] = obj.getCreatetime().toString();
		            content[i][3] = obj.getLevel().toString();
		            content[i][4] = obj.getPid();
	}
	
	//创建HSSFWorkbook 
	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
	//响应到客户端
	try {
	this.setResponseHeader(response, fileName);
	OutputStream os = response.getOutputStream();
	wb.write(os);
	os.flush();
	os.close();

	} catch (Exception e) {
		// TODO: handle exception
	}
	    }
	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
