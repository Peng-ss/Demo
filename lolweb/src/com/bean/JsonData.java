package com.bean;

import java.util.List;

//创建一个解析JSON数据类
//属性：count datas JsonData result message
//方法：无参构造，有参构造，各个属性的set,get方法和toString方法
public class JsonData {
	private int count;
	private List<User> datas;
	private String message;
	private boolean result;

	public JsonData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonData(int count, List<User> datas, String message, Boolean result) {
		super();
		this.count = count;
		this.datas = datas;
		this.message = message;
		this.result = result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<User> getDatas() {
		return datas;
	}

	public void setDatas(List<User> datas) {
		this.datas = datas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "JsonDate [count=" + count + ", datas=" + datas + ", message=" + message + ", result=" + result + "]";
	}

}
