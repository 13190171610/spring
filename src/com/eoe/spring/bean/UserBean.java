/** 
 * Project Name:SpringMVC03 
 * File Name:UserBean.java 
 * Package Name:com.eoe.spring.bean 
 * Date:2016年5月30日下午3:34:27 
 * Author:ls
 */
package com.eoe.spring.bean;

import java.util.Arrays;
import java.util.Date;

/**
 * ClassName: UserBean ClassInto: (用一句话描述这个变量表示什么).
 */
public class UserBean {
	private String name;
	private String number;
	private String[] xq;
	private Date date;

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String[] getXq() {
		return xq;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setXq(String[] xq) {
		this.xq = xq;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", number=" + number + ", xq="
				+ Arrays.toString(xq) + ", date=" + date + "]";
	}

}
