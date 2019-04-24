package com.java.xc.domain;

import java.io.Serializable;

public class Sales implements Serializable{
	private int smeid;
	private String smename;
	private String sdate;
	private int scaccount;
	private int snum;
	public Sales() {
		super();
	}
	public Sales(int smeid, String smename, String sdate, int scaccount,
			int snum) {
		super();
		this.smeid = smeid;
		this.smename = smename;
		this.sdate = sdate;
		this.scaccount = scaccount;
		this.snum = snum;
	}
	public int getSmeid() {
		return smeid;
	}
	public void setSmeid(int smeid) {
		this.smeid = smeid;
	}
	public String getSmename() {
		return smename;
	}
	public void setSmename(String smename) {
		this.smename = smename;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getScaccount() {
		return scaccount;
	}
	public void setScaccount(int scaccount) {
		this.scaccount = scaccount;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	
}
