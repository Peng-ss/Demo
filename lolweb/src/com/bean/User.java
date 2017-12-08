package com.bean;

public class User {
	private int balance;
	private int id;
	private String userName;
	private String passWord;
	private int level;

	public User() {
		super();
	}

	public User(int balance, int id, String userName, String passWord, int level) {
		super();
		this.balance = balance;
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [balance=" + balance + ", id=" + id + ", userName=" + userName + ", passWord=" + passWord
				+ ", level=" + level + "]";
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


}