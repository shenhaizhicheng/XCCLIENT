package com.java.xc.biz;

import com.java.xc.domain.Card;

public interface cardBiz {
	//注册成功默认开卡
	public int opencard(int caccount);
	
	//充值
	public boolean cardmoney(int cid,double money);
	
	//挂失(判断卡状态，挂失)
	public boolean dolost(int cid);
	
	//补卡(判断卡状态，补卡，返回新卡号)
	public int buildcard(Card card,int caccount);
	
	//获取卡状态
	public String selectState(int cid);
	
	//根据卡号查找卡
	public Card selectCBycid(int cid);
	
	//根据客户账号查询所属卡的折扣
	public double selectDis(int caccount);

}
