package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Hero;
import com.bean.ResultData;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class FiltHeroTypeHandler {

	public static void filtHeroType(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "SELECT t_hero.*,t_herotype.typeName FROM t_hero,t_herotype WHERE t_hero.heroType_id ="
					+arg0.getParameter("userType.id")
					+" AND t_herotype.id ="
					+arg0.getParameter("userType.id");
		ResultData rd =  new ResultData();
		ArrayList<Hero> list =JDBC_Utils.Query(new Hero(), sql);
		if (list.size()>=1) {
			rd.setDatasHero(list);
			rd.setCount(list.size());
			rd.setMessage("查询成功");
			rd.setResult(true);
		}
		else {
			rd.setMessage("没有该类型的英雄，查询失败");
			rd.setCount(list.size());
			rd.setResult(false);
		}
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");

	}

}
