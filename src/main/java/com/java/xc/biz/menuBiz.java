package com.java.xc.biz;

import java.util.List;
import java.util.Map;

import com.java.xc.domain.Menu;
import com.java.xc.domain.ShopCar;

public interface menuBiz {
	//添加菜品
		public String insertMenu(Menu m);
		
		//根据编号移除菜品
		public String deleteMenu(int meid);
		
		//根据编号修改折扣
		public String updateMenu(int meid,double mediscount);
		
		//查找所有菜品
		public List<Menu> selectAllMe();
		
		//根据编号查找菜信息
		public Menu selectBymeid(int meid);
		
		//查找所有菜品类型
		public Map<Integer,String> selectAlltype();
}
