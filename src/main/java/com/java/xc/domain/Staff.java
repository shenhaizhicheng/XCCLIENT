package com.java.xc.domain;

import java.io.Serializable;

public class Staff implements Serializable{
	private int saccount;
	private String sname;
	private String spassword;
	private String sposition;
	private String semail;
	public Staff(String sname, String sposition, String semail) {
		super();
		this.sname = sname;
		this.sposition = sposition;
		this.semail = semail;
	}

	public Staff() {
		super();
		
	}

	public int getSaccount() {
		return saccount;
	}
	public void setSaccount(int saccount) {
		this.saccount = saccount;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSposition() {
		return sposition;
	}
	public void setSposition(String sposition) {
		this.sposition = sposition;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	
}
