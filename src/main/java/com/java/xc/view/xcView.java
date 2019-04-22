package com.java.xc.view;

public class xcView {
        public void Mainmenu(){
        	System.out.println(" ");
        	System.out.println("-----------------------------");
        	System.out.println("|     欢迎进入想吃自助点餐系统                   |");
        	System.out.println("-----------------------------");
        	System.out.println("1.登录");
        	System.out.println("2.用户注册");
        	System.out.println("3.忘记账号或密码");
        	System.out.println(" ");
    
        }
        
        public void Clientmenu(){
        	System.out.println(" ");
        	System.out.println("-----------点餐界面-----------");
        	System.out.println("1.点餐");
        	System.out.println("2.查看购物车");
        	System.out.println("3.删除菜品");
        	System.out.println("4.结账");
        	System.out.println("5.卡系统");
        	System.out.println("6.退出登录");
        	System.out.println(" ");
        }
        
        public void Cardmenu(){
        	System.out.println(" ");
        	System.out.println("-----------卡系统-------------");
        	System.out.println("1.充值");
        	System.out.println("2.挂失");
        	System.out.println("3.补卡");
        	System.out.println("4.解除挂失");
        	System.out.println("5.查询余额");
        	System.out.println(" ");
        }
        
        public void Managermenu(){
        	System.out.println(" ");
        	System.out.println("-----------管理界面--------------");
        	System.out.println("1.添加菜品");
        	System.out.println("2.卡冻结");
        	System.out.println("3.设置菜品折扣");
        	System.out.println("4.导出月销售单");
        	System.out.println("5.退出登录");
        }
}
