package com.handler;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.ResultData;
import com.bean.User;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class LoginHandler {
	public static void login(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "SELECT * FROM t_user WHERE userName='" + arg0.getParameter("userName") + "' AND `password"
				+ "` ='" + arg0.getParameter("password") + "'";
		ResultData rd = new ResultData();
		ArrayList<User> users = JDBC_Utils.Query(new User(), sql);
		if (users.size() > 0) {
			// 用户和密码没有错误
			rd.setMessage("登录成功");
			rd.setResult(true);
			rd.setDatas(users);
		} else {
			// 用户和密码错误
			rd.setMessage("登录失败");
			rd.setResult(false);
		}
		rd.setCount(users.size());
		Servlet_Util.turn(arg0, arg1,rd,"result.jsp");

	}
}
