package com.bean;

public class Hero {
	private int heroType_id;
	private String typeName;
	private String heroName;
	private String heroTitle;
	private String heroContry;
	private String heroLines;
	private int heroPrice;
	private String imgURL;
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hero(int heroType_id, String typeName, String heroName, String heroTitle, String heroContry,
			String heroLines, int heroPrice, String imgURL) {
		super();
		this.heroType_id = heroType_id;
		this.typeName = typeName;
		this.heroName = heroName;
		this.heroTitle = heroTitle;
		this.heroContry = heroContry;
		this.heroLines = heroLines;
		this.heroPrice = heroPrice;
		this.imgURL = imgURL;
	}
	public int getHeroType_id() {
		return heroType_id;
	}
	public void setHeroType_id(int heroType_id) {
		this.heroType_id = heroType_id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getHeroTitle() {
		return heroTitle;
	}
	public void setHeroTitle(String heroTitle) {
		this.heroTitle = heroTitle;
	}
	public String getHeroContry() {
		return heroContry;
	}
	public void setHeroContry(String heroContry) {
		this.heroContry = heroContry;
	}
	public String getHeroLines() {
		return heroLines;
	}
	public void setHeroLines(String heroLines) {
		this.heroLines = heroLines;
	}
	public int getHeroPrice() {
		return heroPrice;
	}
	public void setHeroPrice(int heroPrice) {
		this.heroPrice = heroPrice;
	}
	public String getImgURL() {
		return imgURL;
	}
	@Override
	public String toString() {
		return "Hero [heroType_id=" + heroType_id + ", typeName=" + typeName + ", heroName=" + heroName + ", heroTitle="
				+ heroTitle + ", heroContry=" + heroContry + ", heroLines=" + heroLines + ", heroPrice=" + heroPrice
				+ ", imgURL=" + imgURL + "]";
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
}
