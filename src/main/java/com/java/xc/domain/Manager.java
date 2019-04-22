package com.java.xc.domain;

import java.io.Serializable;

public class Manager implements Serializable{
	private int maccount;
	private String mpassword;
	private String mname;

	public Manager(int maccount, String mpassword, String mname) {
		super();
		this.maccount = maccount;
		this.mpassword = mpassword;
		this.mname = mname;
	}

	public Manager() {
		super();
	}

	public int getMaccount() {
		return maccount;
	}

	public void setMaccount(int maccount) {
		this.maccount = maccount;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	

}
