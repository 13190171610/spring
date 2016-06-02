/** 
 * Project Name:SpringMVC03 
 * File Name:UserController.java 
 * Package Name:com.eoe.spring.controller 
 * Date:2016年5月27日下午1:58:19 
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
 * ClassName: UserController ClassInto: (用一句话描述这个变量表示什么).
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 测试用SpringMVC返回json字符串的两种方式
	 * 
	 * 方式1：通过HttpServletResponse对象的输出流返回
	 */
	// @RequestMapping("/getUser.do")
	// public void getUser(HttpServletResponse response, HttpServletRequest
	// request) {
	// response.setContentType("application/json; charset=UTF-8");
	// String json = null;
	// System.out.println("-----------查询用户信息------------");
	// System.out.println("request:" + request.getParameter("request"));
	// UserBean userBean = new UserBean();
	// userBean.setName("张三");
	// userBean.setNumber("01");
	// userBean.setXq(new String[] { "唱歌", "跑步" });
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
	 * 测试用SpringMVC返回json字符串的两种方式
	 * 
	 * 方式2：通过 ResponseBody注解直接返回对象，spring自动转换json
	 */
	@RequestMapping("/getUser.do")
	@ResponseBody
	public Object getUser(HttpServletRequest request) {
		System.out.println("-----------查询用户信息------------");
		System.out.println("request:" + request.getParameter("request"));
		UserBean userBean = new UserBean();
		userBean.setName("张三");
		userBean.setNumber("01");
		userBean.setXq(new String[] { "唱歌", "跑步" });
		return userBean;
	}

	@RequestMapping("/addUser.do")
	public String addUser(Model model) {
		model.addAttribute("hello", "213123");
		System.out.println("-----------添加用户信息------------");
		return "userinfo/user_add";
	}

	@RequestMapping("/updateUser.do")
	public String updateUser() {
		System.out.println("-----------修改用户信息------------");
		return "userinfo/user_update";
	}

	@RequestMapping("/getInfo.do")
	// 获取请求参数
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
	 * 时间属性转换器
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		CustomDateEditor customDateEditor = new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
		binder.registerCustomEditor(Date.class, customDateEditor);
	}

}
