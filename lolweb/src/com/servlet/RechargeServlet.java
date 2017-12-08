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

@WebServlet("/recharge")
public class RechargeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JsonData jsonData = null;
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String url = HttpUtil.URL_BASE + "recharge" + "&userName=" +arg0.getParameter("username") +"&password=" + arg0.getParameter("password")+ "&balance=" + arg0.getParameter("balance");
		String jsonStr = OkHttpUtiles.getJsonData(url);
		if (jsonStr != null) {
			jsonData = Json_Utile.getJsonData(jsonStr);
			jsonData.setMessage("充值成功！");
			arg0.setAttribute("jsonData", jsonData);
			ArrayList<Hero> heros = Json_Utile.getHero(jsonData.getDatas().get(0).getId());
			ArrayList<Hero> buyHeros = Json_Utile.buyHeros();
			arg0.setAttribute("buyHeros", buyHeros);
			arg0.setAttribute("heros", heros);
			arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
		} else {
			jsonData.setMessage("充值失败！");
			jsonData.setResult(false);
			arg0.setAttribute("jsonData", jsonData);
			arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
		}
	}
}
