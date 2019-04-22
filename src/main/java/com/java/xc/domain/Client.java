package com.java.xc.domain;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable{
	private int caccount;
	private String cpassword;
	private String cname;
	private String csex;
	private Date cbirth;
	private String cemail;
	private Card card;
	public Client(String cpassword, String cname, String csex, Date cbirth, String cemail) {
		super();
		this.cpassword = cpassword;
		this.cname = cname;
		this.csex = csex;
		this.cbirth = cbirth;
		this.cemail = cemail;
	}
	public Client() {
		super();
		
	}
	public int getCaccount() {
		return caccount;
	}
	public void setCaccount(int caccount) {
		this.caccount = caccount;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public Date getCbirth() {
		return cbirth;
	}
	public void setCbirth(Date cbirth) {
		this.cbirth = cbirth;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	

}
