package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Hero;
import com.bean.ResultData;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class HerosHandler {

	public static void heros(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "SELECT t_hero.*,t_herotype.typeName FROM t_hero,t_herotype WHERE t_hero.heroType_id = t_herotype.id";
		ResultData rd =  new ResultData();
		ArrayList<Hero> list =JDBC_Utils.Query(new Hero(), sql);
		rd.setDatasHero(list);
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");
 	}

}
