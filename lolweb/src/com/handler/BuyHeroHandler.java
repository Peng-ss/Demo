package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Hero;
import com.bean.ResultData;
import com.bean.User;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class BuyHeroHandler {

	public static void buyHero(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "SELECT t_hero.*,t_herotype.typeName FROM t_hero,t_herotype WHERE t_hero.id ="
				+ arg0.getParameter("t_hero.id") + " AND t_herotype.id=" + arg0.getParameter("t_hero.id");
		ResultData rd = new ResultData();
		ArrayList<Hero> hero = JDBC_Utils.Query(new Hero(), sql);
		String userIsExits = "SELECT * FROM t_user WHERE id='" + arg0.getParameter("user_id") + "'";
		ArrayList<User> userList = JDBC_Utils.Query(new User(), userIsExits);
		if (hero.get(0).getHeroPrice() <= userList.get(0).getBalance()) {
			sql = "INSERT INTO t_userhero(user_id,hero_id) VALUES(" + arg0.getParameter("user_id") + ","
					+ arg0.getParameter("t_hero.id") + ")";
			int count = JDBC_Utils.JDBC_Update(sql);
			if (count == 1) {
				sql = "SELECT t_hero.*,t_herotype.typeName FROM t_hero,t_herotype WHERE t_hero.id="
						+ arg0.getParameter("t_hero.id") + " AND t_herotype.id=" + arg0.getParameter("t_hero.id");
				rd.setMessage("购买" + hero.get(0).getHeroName() + "英雄成功");
				sql = "UPDATE t_user SET balance = balance -" + hero.get(0).getHeroPrice() + " WHERE id = '"
						+ arg0.getParameter("user_id") + "'";
				int num = JDBC_Utils.JDBC_Update(sql);
				userIsExits = "SELECT * FROM t_user WHERE id='" + arg0.getParameter("user_id") + "'";
				ArrayList<User> userList1 = JDBC_Utils.Query(new User(), userIsExits);
				rd.setDatas(userList1);
				rd.setCount(num);
				rd.setResult(true);
			} else {
				rd.setMessage("你已经拥有该英雄");
				rd.setCount(count);
				rd.setResult(true);
			}
		} else {
			rd.setMessage("余额不够，购买失败");
			rd.setCount(0);
			rd.setResult(false);
			rd.setDatas(userList);
		}
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");
	}

}
