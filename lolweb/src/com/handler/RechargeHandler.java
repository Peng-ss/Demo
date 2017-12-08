package com.handler;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.ResultData;
import com.bean.User;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class RechargeHandler {
	public static void recharge(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "UPDATE t_user SET balance = balance +" + arg0.getParameter("balance") + " WHERE userName = '"
				+ arg0.getParameter("userName") + "' AND `password` = '" + arg0.getParameter("password") + "'";
		ResultData rd = new ResultData();
		int count = JDBC_Utils.JDBC_Update(sql);
		if (count >= 1) {
			// 用户和密码没有错误
			rd.setMessage("充值成功");
			rd.setResult(true);
			rd.setCount(count);
			String userIsExits = "SELECT * FROM t_user WHERE userName='" + arg0.getParameter("userName") + "'";
			ArrayList<User> userList = JDBC_Utils.Query(new User(),userIsExits);
			rd.setDatas(userList);
		} else {
			// 用户和密码错误
			rd.setMessage("充值失败");
			rd.setResult(false);
			rd.setCount(count);
		}
		Servlet_Util.turn(arg0, arg1, rd, "result.jsp");
	}
}
