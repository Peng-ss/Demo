package com.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResultData;
import com.bean.User;
import com.utils.JDBC_Utils;
import com.utils.Servlet_Util;

public class PayHandler {

	public static void pay(HttpServletRequest arg0, HttpServletResponse arg1) {
		String sql = "UPDATE t_user SET balance = balance -" + arg0.getParameter("balance") + " WHERE userName = '"
				+ arg0.getParameter("userName") + "' AND `password` = '" + arg0.getParameter("password") + "'";
		String userIsExits = "SELECT * FROM t_user WHERE userName='"
				+arg0.getParameter("userName")+"'";
		ArrayList<User> userList = JDBC_Utils.Query(new User(), sql);
		ResultData rd = new ResultData();
		int count = JDBC_Utils.JDBC_Update(sql);
		if (arg0.getParameter("password") == userList.get(0).getPassWord()) {
			if(count ==1 && Integer.parseInt(arg0.getParameter("balance"))<=userList.get(0).getBalance()){
				// 用户和密码没有错误
				rd.setMessage("付款成功");
				rd.setResult(true);
				rd.setCount(count);
				userIsExits = "SELECT * FROM t_user WHERE userName='"
						+arg0.getParameter("userName")+"'";
				ArrayList<User> userList1 = JDBC_Utils.Query(new User(), userIsExits);
				rd.setDatas(userList1);
			}
			else{
				// 付款失败，余额不足
				rd.setMessage("付款失败，余额不足");
				rd.setResult(false);
				rd.setCount(count);
			}
		} else {
			// 用户和密码错误
			rd.setMessage("用户和密码错误");
			rd.setResult(false);
			rd.setCount(count);
		}

		Servlet_Util.turn(arg0, arg1,rd,"result.jsp");

	}

}
