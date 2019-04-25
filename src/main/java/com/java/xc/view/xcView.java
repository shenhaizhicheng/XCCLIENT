package com.java.xc.view;

public class xcView {
        public void Mainmenu(){  //主界面
        	System.out.println(" ");
        	System.out.println("-----------------------------");
        	System.out.println("|     欢迎进入想吃自助点餐系统                   |");
        	System.out.println("-----------------------------");
        	System.out.println("           1.登录");
        	System.out.println("           2.用户注册");
        	System.out.println("           3.忘记账号或密码");
        	
        	System.out.println(" ");
    
        }
        
        public void Clientmenu(){  //客户登陆界面
        	System.out.println(" ");
        	System.out.println("-----------点餐界面-----------");
        	System.out.println("          1.点餐");
        	System.out.println("          2.查看购物车");
        	System.out.println("          3.删除菜品");
        	System.out.println("          4.结账");
        	System.out.println("          5.卡系统");
        	System.out.println("          6.修改密码");
        	System.out.println("          7.退出登录");
        	System.out.println(" ");
        }
        
        public void Cardmenu(){ //卡系统显示界面
        	System.out.println(" ");
        	System.out.println("-----------卡系统-------------");
        	System.out.println("          1.充值");
        	System.out.println("          2.挂失");
        	System.out.println("          3.补卡");
        	System.out.println("          4.解除挂失");
        	System.out.println("          5.查询余额");
        	System.out.println("          6.查询积分");
        	System.out.println("          7.返回上一级");
        	System.out.println(" ");
        }
        
        public void Managermenu(){//经理登录显示界面
        	System.out.println(" ");
        	System.out.println("-----------管理界面--------------");
        	System.out.println("          1.添加菜品");
        	System.out.println("          2.卡冻结");
        	System.out.println("          3.设置菜品折扣");
        	System.out.println("          4.导出月销售单");
        	System.out.println("          5.查看月销量排行");
        	System.out.println("          6.清空月销售单");
        	System.out.println("          7.添加员工");
        	System.out.println("          8.删除员工");
        	System.out.println("          9.发放福利");
        	System.out.println("          10.退出登录");
        }
        
        public void cardAC(){  //本店充值活动
        	System.out.println("          |本店活动：一次性充值300元以上600元以下，自动由普通用户升级为vip|");
    		System.out.println("          |       一次性充值600元以上，自动由普通用户升级为svip      |");
    		System.out.println("          |       一次性充值200元以上赠50元                                                             |");

        }
        
        public void Staffmenu(){  //员工登陆界面
        	System.out.println(" ");
        	System.out.println("-----------员工界面--------------");
        	System.out.println("          1.订单接收");
        	System.out.println("          2.修改密码");
        	System.out.println("          3.订单删除");
        	System.out.println("          4.退出登录");
        }
}
