package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Hero;
import com.bean.ResultData;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class SelectHero {

	public static void getHero(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = " SELECT h.heroType_id,ht.typeName,h.heroName,h.heroTitle,h.heroContry,h.heroLines,h.heroPrice,h.imgURL "
				+ "FROM t_user AS u ,t_hero AS h,t_userhero AS uh ,t_herotype AS ht " + "WHERE uh.user_id="
				+ arg0.getParameter("user_id") + " AND u.id =" + arg0.getParameter("user_id")
				+ " AND uh.hero_id= h.id AND ht.id = h.id";
		ArrayList<Hero> heroList = JDBC_Utils.Query(new Hero(),sql);
		ResultData rd = new ResultData();
		if (heroList.size()>0) {
			rd.setDatasHero(heroList);
			rd.setMessage("查询成功");
			rd.setResult(true);
			rd.setCount(heroList.size());
		} else {
			rd.setMessage("该用户没有英雄,查询失败");
			rd.setResult(false);
			rd.setCount(0);
		}
		Servlet_Util.turn(arg0, arg1,rd,"result.jsp");
		
	}

}
