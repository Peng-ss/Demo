package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Hero;
import com.bean.HeroType;
import com.bean.User;

public class JDBC_Utils {
	// 使服务器启动时，只加载和注册一次数据库驱动
	// 使用静态构造代码块，可以解决这个问题
	// 静态构造代码块，特性：只加载一次，且只执行一次
	// 代码块：被{}括起来的代码片段，就是代码块
	// 静态构造代码块：被static修饰的代码块，存在于类中方（方法）
	static {
		// 在这里加载和注册驱动，只会执行一次
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 连接数据库对象
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/lol", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 用于执行DDL，DML操作，返回的数据是被影响的行数
	public static int JDBC_Update(String sql) {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			int num = st.executeUpdate(sql);
			closeAll(null, st, conn);
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * // 创建一个方法，用于获取查询用户信息结果 public static ArrayList<User> JDBC_Query(String
	 * sql) { ArrayList<User> list = new ArrayList<User>(); try { Connection
	 * conn = getConnection(); Statement st = conn.createStatement(); ResultSet
	 * result = st.executeQuery(sql); while (result.next()) { User user = new
	 * User(result.getInt("balance"), result.getInt("id"),
	 * result.getString("userName"), result.getString("password"),
	 * result.getInt("level")); list.add(user); } closeAll(result, st, conn); }
	 * catch (SQLException e) { e.printStackTrace(); } return list;
	 * 
	 * }
	 * 
	 * // 创建一个方法，用于获取英雄的类型 public static ArrayList<HeroType>
	 * JDBC_heroTypeQuery(String sql) { ArrayList<HeroType> list = new
	 * ArrayList<HeroType>(); try { Connection conn = getConnection(); Statement
	 * st = conn.createStatement(); ResultSet result = st.executeQuery(sql);
	 * while (result.next()) { HeroType heroType = new
	 * HeroType(result.getInt("id"), result.getString("typeName"));
	 * list.add(heroType); } } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } return list; }
	 * 
	 * // 创建一个方法，用于获取查询用户英雄信息结果 public static ArrayList<Hero>
	 * JDBC_heroQuery(String sql) { ArrayList<Hero> list = new
	 * ArrayList<Hero>(); try { Connection conn = getConnection(); Statement st
	 * = conn.createStatement(); ResultSet result = st.executeQuery(sql); while
	 * (result.next()) { Hero hero = new Hero(result.getInt("heroType_id"),
	 * result.getString("typeName"), result.getString("heroName"),
	 * result.getString("heroTitle"), result.getString("heroContry"),
	 * result.getString("heroLines"), result.getInt("heroPrice"),
	 * result.getString("imgURL")); list.add(hero); } closeAll(result, st,
	 * conn); } catch (SQLException e) { e.printStackTrace(); } return list;
	 * 
	 * }
	 */
	// 可变泛型
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> Query(T t, String sql) {
		ArrayList<T> list = new ArrayList<T>();
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			if (t instanceof User) {
				while (result.next()) {
					User user = new User(result.getInt("balance"), result.getInt("id"), result.getString("userName"),
							result.getString("password"), result.getInt("level"));
					list.add((T) user);
				}
			} else if (t instanceof Hero) {
				while (result.next()) {
					Hero hero = new Hero(result.getInt("heroType_id"), result.getString("typeName"),
							result.getString("heroName"), result.getString("heroTitle"), result.getString("heroContry"),
							result.getString("heroLines"), result.getInt("heroPrice"), result.getString("imgURL"));
					list.add((T) hero);
				}
				closeAll(result, st, conn);
			} else if (t instanceof HeroType) {
				while (result.next()) {
					HeroType heroType = new HeroType(result.getInt("id"), result.getString("typeName"));
					list.add((T) heroType);
				}
			}
			closeAll(result, st, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<T>) list;
	}
	// 使用 JDBC_Utils.test(new User(), sql);

	// 释放通用资源
	private static void closeAll(ResultSet result, Statement st, Connection conn) {
		try {
			if (result != null) {
				result.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
