package com.java.xc.domain;

import java.io.Serializable;

public class Card implements Serializable{
	private int caid;
	private double cabalance;
	private String catype;
	private String castate;
	private double cainteggral;

	public double getCainteggral() {
		return cainteggral;
	}

	public void setCainteggral(double cainteggral) {
		this.cainteggral = cainteggral;
	}

	public Card(double cabalance, String catype, String castate,
			double cainteggral) {
		super();
		this.cabalance = cabalance;
		this.catype = catype;
		this.castate = castate;
		this.cainteggral = cainteggral;
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public double getCabalance() {
		return cabalance;
	}

	public void setCabalance(double cabalance) {
		this.cabalance = cabalance;
	}

	public String getCatype() {
		return catype;
	}

	public void setCatype(String catype) {
		this.catype = catype;
	}

	public String getCastate() {
		return castate;
	}

	public void setCastate(String castate) {
		this.castate = castate;
	}

	
}
