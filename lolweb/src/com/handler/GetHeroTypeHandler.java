package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HeroType;
import com.bean.ResultData;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;



public class GetHeroTypeHandler {

	public static void getHeroType(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "SELECT * FROM t_herotype ";
		ResultData rd = new ResultData();
		ArrayList<HeroType> heroTypes = new ArrayList<HeroType>();
		heroTypes = JDBC_Utils.Query(new HeroType(), sql);
		rd.setDatasHeroType(heroTypes);
		rd.setCount(0);
		rd.setMessage("查询成功");
		rd.setResult(true);
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");
	}
}
