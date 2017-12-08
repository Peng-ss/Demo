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

@WebServlet("/buyHero")
public class BuyHeroServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JsonData jsonData = null;
	JsonData jsonDataUser = null;
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String url = HttpUtil.URL_BASE + "buyHero" + "&userName=" + arg0.getParameter("username") + "&user_id="
				+ arg0.getParameter("user_id") + "&t_hero.id=" + arg0.getParameter("t_hero.id");
		String url1 = HttpUtil.URL_BASE + "login" + "&userName=" + arg0.getParameter("username") + "&password="
				+ arg0.getParameter("password");
		String jsonStr = OkHttpUtiles.getJsonData(url);
		String jsonUser = OkHttpUtiles.getJsonData(url1);
		jsonData = new JsonData();
		jsonDataUser = new JsonData();
		JsonData jsonDataUser = Json_Utile.getJsonData(jsonUser);
		ArrayList<Hero> heros = Json_Utile.getHero(jsonDataUser.getDatas().get(0).getId());
		ArrayList<Hero> buyHeros = Json_Utile.buyHeros();
		if (jsonStr.indexOf("你已经拥有该英雄") !=-1) {
			jsonDataUser.setMessage("英雄已存在");
			arg0.setAttribute("buyHeros", buyHeros);
			arg0.setAttribute("jsonData", jsonDataUser);
			arg0.setAttribute("heros", heros);
			arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
		}
		else if (jsonStr.indexOf("余额不够，购买失败") !=-1) {
			jsonDataUser.setMessage("余额不足");
			arg0.setAttribute("jsonData", jsonDataUser);
			arg0.setAttribute("buyHeros", buyHeros);
			arg0.setAttribute("heros", heros);
			arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
		}
		else if (jsonStr.indexOf("英雄成功") !=-1) {
			jsonDataUser.setMessage("购买英雄成功");
			arg0.setAttribute("buyHeros", buyHeros);
			arg0.setAttribute("jsonData", jsonDataUser);
			arg0.setAttribute("heros", heros);
			arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
		}
	}
}
