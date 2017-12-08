package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.handler.BuyHeroHandler;
import com.handler.FiltHeroTypeHandler;
import com.handler.GetHeroTypeHandler;
import com.handler.HerosHandler;
import com.handler.LoginHandler;
import com.handler.PayHandler;
import com.handler.RechargeHandler;
import com.handler.RegisterHandler;
import com.handler.SelectHero;

@WebServlet("/my")
public class MainServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String type = arg0.getParameter("type");
		// 两个字符串比较 equals方法
		// 注册
		if ("register".equals(type)) {
			RegisterHandler.register(arg0, arg1);
		}
		// 登录
		else if ("login".equals(type)) {
			LoginHandler.login(arg0, arg1);
		}
		// 付款
		else if ("pay".equals(type)) {
			PayHandler.pay(arg0, arg1);
		}
		// 充值
		else if ("recharge".equals(type)) {
			RechargeHandler.recharge(arg0, arg1);
		}
		//查询拥有英雄
		else if ("getHero".equals(type)) {
			SelectHero.getHero(arg0, arg1);
		} 
		//购买英雄
		else if ("buyHero".equals(type)) {
			BuyHeroHandler.buyHero(arg0, arg1);
		}
		//查询英雄类型
		else if ("getHeroTyoe".equals(type)) {
			GetHeroTypeHandler.getHeroType(arg0,arg1);
		}
		//查询设置好的英雄
		else if ("heros".equals(type)) {
			HerosHandler.heros(arg0,arg1);
		}
		//通过英雄类型筛选英雄
		else if ("filteHeroType".equals(type)) {
			FiltHeroTypeHandler.filtHeroType(arg0,arg1);
		}
	}
}
