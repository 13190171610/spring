/** 
 * Project Name:SpringMVC03 
 * File Name:UserController.java 
 * Package Name:com.eoe.spring.controller 
 * Date:2016��5��27������1:58:19 
 * Author:ls
 */
package com.eoe.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eoe.spring.bean.UserBean;

/**
 * ClassName: UserController ClassInto: (��һ�仰�������������ʾʲô).
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * ������SpringMVC����json�ַ��������ַ�ʽ
	 * 
	 * ��ʽ1��ͨ��HttpServletResponse��������������
	 */
	// @RequestMapping("/getUser.do")
	// public void getUser(HttpServletResponse response, HttpServletRequest
	// request) {
	// response.setContentType("application/json; charset=UTF-8");
	// String json = null;
	// System.out.println("-----------��ѯ�û���Ϣ------------");
	// System.out.println("request:" + request.getParameter("request"));
	// UserBean userBean = new UserBean();
	// userBean.setName("����");
	// userBean.setNumber("01");
	// userBean.setXq(new String[] { "����", "�ܲ�" });
	// Gson gson = new Gson();
	// json = gson.toJson(userBean);
	// System.out.println(json);
	// try {
	// response.getWriter().print(json);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * ������SpringMVC����json�ַ��������ַ�ʽ
	 * 
	 * ��ʽ2��ͨ�� ResponseBodyע��ֱ�ӷ��ض���spring�Զ�ת��json
	 */
	@RequestMapping("/getUser.do")
	@ResponseBody
	public Object getUser(HttpServletRequest request) {
		System.out.println("-----------��ѯ�û���Ϣ------------");
		System.out.println("request:" + request.getParameter("request"));
		UserBean userBean = new UserBean();
		userBean.setName("����");
		userBean.setNumber("01");
		userBean.setXq(new String[] { "����", "�ܲ�" });
		return userBean;
	}

	@RequestMapping("/addUser.do")
	public String addUser(Model model) {
		model.addAttribute("hello", "213123");
		System.out.println("-----------����û���Ϣ------------");
		return "userinfo/user_add";
	}

	@RequestMapping("/updateUser.do")
	public String updateUser() {
		System.out.println("-----------�޸��û���Ϣ------------");
		return "userinfo/user_update";
	}

	@RequestMapping("/getInfo.do")
	// ��ȡ�������
	public String getInfo(UserBean userBean) {
		System.out.println(userBean);
		return "userinfo/success";
	}

	@RequestMapping("/getDate.do")
	public String getDate(Date date) {
		System.out.println(date);
		System.out.println("!!");
		return "userinfo/success";
	}

	/**
	 * ʱ������ת����
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		CustomDateEditor customDateEditor = new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
		binder.registerCustomEditor(Date.class, customDateEditor);
	}

}
