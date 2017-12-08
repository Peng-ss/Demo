package com.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class Servlet_Util {

	public static void turn(HttpServletRequest arg0, HttpServletResponse arg1, Object object, String string) {
		Object json = JSON.toJSON(object);
		arg0.setAttribute("json", json);
		try {
			arg0.getRequestDispatcher(string).forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
