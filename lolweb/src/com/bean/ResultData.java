package com.bean;

import java.util.List;

public class ResultData {
	private String message;
	private boolean  result;
	private int count;
	private List<User> datas;
	private List<Hero> datasHero;
	private List<HeroType> datasHeroType;
	public ResultData(String message, boolean result, int count, List<User> datas, List<Hero> datasHero,
			List<HeroType> datasHeroType) {
		super();
		this.message = message;
		this.result = result;
		this.count = count;
		this.datas = datas;
		this.datasHero = datasHero;
		this.datasHeroType = datasHeroType;
	}
	public ResultData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
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
	public List<Hero> getDatasHero() {
		return datasHero;
	}
	public void setDatasHero(List<Hero> datasHero) {
		this.datasHero = datasHero;
	}
	public List<HeroType> getDatasHeroType() {
		return datasHeroType;
	}
	public void setDatasHeroType(List<HeroType> datasHeroType) {
		this.datasHeroType = datasHeroType;
	}
	@Override
	public String toString() {
		return "ResultData [message=" + message + ", result=" + result + ", count=" + count + ", datas=" + datas
				+ ", datasHero=" + datasHero + ", datasHeroType=" + datasHeroType + "]";
	}
	
	
}
