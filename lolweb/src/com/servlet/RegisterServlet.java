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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JsonData jsonData = null;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String url = HttpUtil.URL_BASE + "register" + "&userName=" + arg0.getParameter("userName") + "&password="
				+ arg0.getParameter("password") + "&level=" + arg0.getParameter("level");
		String jsonStr = OkHttpUtiles.getJsonData(url);
		jsonData = new JsonData();
		if (jsonStr != null) {
			// 获取返回的数据
			if (jsonStr.indexOf("用户已经存在") == -1) {
				jsonData = Json_Utile.getJsonData(jsonStr);
				arg0.setAttribute("jsonData", jsonData);
				ArrayList<Hero> buyHeros = Json_Utile.buyHeros();
				arg0.setAttribute("buyHeros", buyHeros);
				arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
			} else {
				jsonData.setResult(false);
				arg0.setAttribute("jsonData", jsonData);
				arg0.getRequestDispatcher("register.jsp").forward(arg0, arg1);
			}
		} else {
			jsonData.setMessage("服务器连接失败");
			jsonData.setResult(false);
		}
	}
}
