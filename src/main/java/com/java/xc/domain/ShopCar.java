package com.java.xc.domain;

import java.io.Serializable;


public class ShopCar implements Serializable{
	private Menu m;
	private int menum;
	private Client c;
	public ShopCar() {
		super();
	}
	public ShopCar(Menu m, int menum, Client c) {
		super();
		this.m = m;
		this.menum = menum;
		this.c = c;
	}
	public Menu getM() {
		return m;
	}
	public void setM(Menu m) {
		this.m = m;
	}
	public int getMenum() {
		return menum;
	}
	public void setMenum(int menum) {
		this.menum = menum;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	
	
}
