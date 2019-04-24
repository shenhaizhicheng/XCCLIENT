package com.java.xc.biz;

import java.util.List;
import java.util.Map;

import com.java.xc.domain.Card;
import com.java.xc.domain.Client;
import com.java.xc.domain.Manager;
import com.java.xc.domain.Menu;
import com.java.xc.domain.ShopCar;
import com.java.xc.domain.Staff;

public interface totalBiz {

	// 根据cc号(账户名)查找经理信息
	public Manager selectBymac(int maccount);

	// 添加客户信息,并为其开一张新卡
	public String cliAndcard(Client c);

	// 根据邮箱查找客户信息
	public Client selectByemail(String cemail);

	// 根据cc号(账户名)查找客户信息
	public Client selectBycac(int caccount);

	// 查找所有客户信息
	public List<Client> selectAllcli();

	// 客户修改密码
	public String updatePass(int caccount, String cpassword);

	// ---------------卡系统-----------------------
	// 充值
	public double cardmoney(int cid, double money);

	// 挂失
	public String dolost(int cid);

	// 获取卡状态
	public String selectState(int cid);

	// 补卡(判断卡状态，补卡，返回新卡号)
	public Card buildcard(Card card, int caccount);

	// 根据卡号查找卡
	public Card selectBycid(int cid);

	// 修改卡上余额
	public double updateBa(int cid, double price);

	// 根据客户账号查询所属卡的折扣
	public double selectDis(int caccount);

	// 解除卡挂失
	public String relieveC(int cid);

	// 修改积分
	public double updateInt(int cid, double caintegral);

	// 查询卡上积分
	public double selectInt(int cid);

	// 修改卡类型
	public boolean updateType(int cid, String catype);

	// --------------购物车-------------------------
	// 添加购物车
	public String insertShopcar(ShopCar s);

	// 移除指定数量商品
	public String deleteMenuS(int meid, int menum, int caccount);// ...

	// 在购物车里按菜品编号查找相关菜信息
	public ShopCar selectBymeid(int meid, int caccount);

	// 计算用户消费总金额
	public double addMoney(int caccount);// ...

	// 按登录账户查找菜列表
	public List<ShopCar> selectMBycac(int caccount);

	// 把指定用户的商品信息添加到月销售单
	public boolean insertSales(Map<ShopCar, Double> map);// 判断日期，菜名，同时符合时只数量增加

	// 查询本月销量排行
	public Map<String, Integer> salesTall();

	// 清空月销售账单
	public boolean deleteSale();

	// 查询所有订单号根据时间排序
	public List<String> selectOFid();

	// 根据订单号查询菜品名称及数量
	public Map<String, Integer> selectByOfid(String ofid);

	// 删除订单按订单号
	public boolean deleteByofid(String ofid);

	// 查看本月热销菜编号
	public int selectIDSalT();

	// 导出月销售单
	public String exportSales();

	// --------------菜单---------------------------
	// 添加菜品
	public String insertMenu(Menu m);

	// 根据编号移除菜品
	public String deleteMenu(int meid);

	// 根据编号修改折扣
	public String updateMenu(int meid, double mediscount);

	// 查找所有菜品
	public List<Menu> selectAllMe();

	// 根据编号查找菜信息
	public Menu selectBymeid(int meid);

	// 查找所有菜品类型
	public Map<Integer, String> selectAlltype();

	// 下单
	public void insertOrderf(String string, ShopCar sc);

	// -----------------------员工-----------------------------
	// 添加员工（员工account为seq_saccount)返回员工号
	public int insertSta(Staff s);

	// 根据员工号查找员工
	public Staff selectBysac(int saccount);

	// 删除员工根据员工号
	public boolean deleteSta(int saccount);

	// 根据账号修改密码
	public String updatespw(int saccount, String newpw);

}
