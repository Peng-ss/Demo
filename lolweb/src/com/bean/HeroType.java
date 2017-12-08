package com.bean;

public class HeroType {
	private int id;
	private String heroType;
	public HeroType(int id, String heroType) {
		super();
		this.id = id;
		this.heroType = heroType;
	}
	public HeroType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeroType() {
		return heroType;
	}
	public void setHeroType(String heroType) {
		this.heroType = heroType;
	}
	@Override
	public String toString() {
		return "HeroType [id=" + id + ", heroType=" + heroType + "]";
	}
	
}
