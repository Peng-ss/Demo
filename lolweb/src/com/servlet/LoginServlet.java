package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Hero;
import com.bean.JsonData;
import com.utils.HttpUtil;
import com.utils.Json_Utile;
import com.utils.OkHttpUtiles;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JsonData jsonData = null;
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String url = HttpUtil.URL_BASE + "login" + "&userName=" + arg0.getParameter("username") + "&password="
				+ arg0.getParameter("password");
		// 通过方法，获取到网络返回到的JSON数据
		String jsonStr = OkHttpUtiles.getJsonData(url);
		jsonData =new JsonData();
		if (jsonStr !=null) {
			if (jsonStr.indexOf("登录成功")!=-1) {
				jsonData = Json_Utile.getJsonData(jsonStr);	
				arg0.setAttribute("jsonData", jsonData);
				ArrayList<Hero> heros = Json_Utile.getHero(jsonData.getDatas().get(0).getId());
				ArrayList<Hero> buyHeros = Json_Utile.buyHeros();
				arg0.setAttribute("buyHeros", buyHeros);
				arg0.setAttribute("heros", heros);
				arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
			}
			else {
				jsonData.setResult(false);
				jsonData.setCount(0);
				jsonData.setMessage("登录失败");
				arg0.setAttribute("jsonData", jsonData);
				arg0.getRequestDispatcher("login.jsp").forward(arg0, arg1);
			}
		}
		else{
			jsonData.setMessage("登录连接失败！！");
			arg0.setAttribute("jsonData", jsonData);
			arg0.getRequestDispatcher("login.jsp").forward(arg0, arg1);
		}
	}
	
}
