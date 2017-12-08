package com.bean;

import java.util.List;

public class HerosData {
	private String result;
	private int count;
	private List<Hero> datasHero;
	@Override
	public String toString() {
		return "HerosData [result=" + result + ", count=" + count + ", datasHero=" + datasHero + "]";
	}
	public HerosData(String result, int count, List<Hero> datasHero) {
		super();
		this.result = result;
		this.count = count;
		this.datasHero = datasHero;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Hero> getDatasHero() {
		return datasHero;
	}
	public void setDatasHero(List<Hero> datasHero) {
		this.datasHero = datasHero;
	}
	public HerosData() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
