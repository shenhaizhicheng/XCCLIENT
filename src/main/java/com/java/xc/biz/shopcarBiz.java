package com.java.xc.biz;

import java.util.List;
import java.util.Map;

import com.java.xc.domain.ShopCar;

public interface shopcarBiz {
	// 添加购物车
	public String insertShopcar(ShopCar s);

	// 移除指定数量商品
	public String deleteMenuS(int meid, int menum,int caccount);// ...

	// 按菜品编号查找相关菜信息
	public ShopCar selectBymeid(int meid,int caccount);

	// 按登录账户查找菜列表
	public List<ShopCar> selectMBycac(int caccount);
	
	//把指定用户的商品信息添加到月销售单
	public boolean insertSales(ShopCar s,double meprofit);//判断日期，菜名，同时符合时只数量增加
	
	//导出excel表
	public boolean exportSales();
}
