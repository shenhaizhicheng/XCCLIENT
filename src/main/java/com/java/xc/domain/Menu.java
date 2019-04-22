package com.java.xc.domain;

import java.io.Serializable;

public class Menu implements Serializable{
	private int meid;
	private String mename;
	private double meprice;
	private int typeid;
	private double mediscount;
	private double mepuprice;

	public Menu(int meid, String mename, double meprice, int typeid, double mediscount, double mepuprice) {
		super();
		this.meid = meid;
		this.mename = mename;
		this.meprice = meprice;
		this.typeid = typeid;
		this.mediscount = mediscount;
		this.mepuprice = mepuprice;
	}

	public Menu() {
		super();

	}

	public int getMeid() {
		return meid;
	}

	public void setMeid(int meid) {
		this.meid = meid;
	}

	public String getMename() {
		return mename;
	}

	public void setMename(String mename) {
		this.mename = mename;
	}

	public double getMeprice() {
		return meprice;
	}

	public void setMeprice(double meprice) {
		this.meprice = meprice;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public double getMediscount() {
		return mediscount;
	}

	public void setMediscount(double mediscount) {
		this.mediscount = mediscount;
	}

	public double getMepuprice() {
		return mepuprice;
	}

	public void setMepuprice(double mepuprice) {
		this.mepuprice = mepuprice;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return meid+"\t"+mename+"\t"+meprice;
	}

}
