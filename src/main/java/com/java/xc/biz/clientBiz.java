package com.java.xc.biz;

import java.util.List;

import com.java.xc.domain.Client;

public interface clientBiz {
	    //添加客户信息
		public int insertCli(Client c);
		
		//根据邮箱查找客户信息
		public Client selectByemail(String cemail);
		
		//根据cc号(账户名)查找客户信息
		public Client selectBycac(int caccount);
		
		//查找所有客户信息
		public List<Client> selectAllcli();
		
		//修改密码
		public String updatePass(int caccount,String cpassword);
}
