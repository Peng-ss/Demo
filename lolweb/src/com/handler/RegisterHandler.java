package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.ResultData;
import com.bean.User;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class RegisterHandler {

	public static void register(HttpServletRequest arg0, HttpServletResponse arg1) {
		// 获取请求参数
		String userName = arg0.getParameter("userName");
		String password = arg0.getParameter("password");
		String level = arg0.getParameter("level");
		String userIsExits = "SELECT * FROM t_user WHERE userName='" + userName + "'";
		ResultData rd = new ResultData();
		if (JDBC_Utils.Query(new User(),userIsExits).size() >= 1) {
			// 如果存在，就返回数据提示当前注册的用户已经存在
			rd.setMessage("用户已经存在");
			rd.setResult(false);
		} else {
			// 处理业务逻辑
			String sql = "INSERT INTO t_user (userName,`password`,`level`)" + " VALUES('" + userName + "','" + password
					+ "'," + level + ");";
			// 调用执行DDL,DML的方法，返回的数据是被影响的行数
			int result = JDBC_Utils.JDBC_Update(sql);
			ArrayList<User> userList = JDBC_Utils.Query(new User(),userIsExits);
			rd.setMessage("注册成功");
			rd.setDatas(userList);
			rd.setResult(true);
			rd.setCount(result);
		}
		// 控制页面跳转
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");

	}
}
