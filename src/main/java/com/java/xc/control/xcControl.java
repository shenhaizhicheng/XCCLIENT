package com.java.xc.control;

import java.io.File;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.java.xc.biz.totalBiz;
import com.java.xc.clientHandle.ProxyClient;
import com.java.xc.domain.Card;
import com.java.xc.domain.Client;
import com.java.xc.domain.Manager;
import com.java.xc.domain.Menu;
import com.java.xc.domain.ShopCar;
import com.java.xc.domain.Staff;
import com.java.xc.util.Email;
import com.java.xc.util.UserInput;
import com.java.xc.view.xcView;

/**
 * @author Administrator
 *
 */
public class xcControl {
	private xcView view;
	private UserInput ui;
	private Email e;
	private Socket client;
	public static final String IP = "10.10.49.78";
	public static final int port = 99;
	private totalBiz tBiz;

	public xcControl() {
		
		view = new xcView();
		ui = new UserInput();
		e = new Email();
		tBiz = ProxyClient.getClient(totalBiz.class, IP, port);
	}

	public void start() {
		int account;
		Client c = null;
		Staff s=null;
		while (true) {
			view.Mainmenu();
			int select = ui.getInt("请做出您的选择:");
			if (select == 1) {
				account = this.login();
				String a = this.Qthree(account);
				if (a.equals("100")) {

					c = this.clogin(account);
					if (c != null) {
						while (true) {
							view.Clientmenu();

							int select2 = ui.getInt("请做出您的选择:");
							if (select2 == 1) {
								this.pickMenu(c);
							} else if (select2 == 2) {
								this.lookShopcar(c);
							} else if (select2 == 3) {
								this.delectMe(c);
							} else if (select2 == 4) {
								this.pay(c);
							} else if (select2 == 5) {

								view.Cardmenu();
								int select3 = ui.getInt("请做出您的选择:");
								if (select3 == 1) {
									this.cardmoney(c);
								} else if (select3 == 2) {
									this.dolose(c);
								} else if (select3 == 3) {
									Card card = this.buildcard(c);
									if (card != null) {
										c.setCard(card);
									}
								} else if (select3 == 4) {
									this.relieveCard(c);
								} else if (select3 == 5) {
									this.selectBa(c);
								}else if (select3 == 6) {
									this.selectInt(c);
								}else if (select3 == 7) {
									
								}

							}else if (select2 == 6) {
								this.updatepw(c);
							} else if (select2 == 7) {
								break;
							}
						}
					}

				} else if (a.equals("200")) {
					Manager m = this.mlogin(account);
					if (m != null) {
						while (true) {
							view.Managermenu();
							int select3 = ui.getInt("请做出您的选择:");
							if (select3 == 1) {
								this.addMenu();
							} else if (select3 == 2) {
								this.Mdolose();
							} else if (select3 == 3) {
								this.setDis();
							} else if (select3 == 4) {
								this.exportSales();
							}else if (select3 == 5) {
								this.findTall();
							}else if (select3 == 6) {
								this.delectSales();
							}else if (select3 == 7) {
								this.insertY();
							}else if (select3 == 8) {
								this.deletteY();
							}else if (select3 == 9) {
								break;
							}
						}
					}

				}else if (a.equals("300")) {
					s = this.slogin(account);
					if(s!=null){
						while(true){
					view.Staffmenu();
					int select4 = ui.getInt("请选择:");
					if(select4==1){
					this.staffmenu();
					}else if(select4==2){
						String str = this.updateSpw(s);
						s.setSpassword(str);
						
					}else if(select4==3){
						this.deleteOf();
					}else if(select4==4){
						break;
					}else{
						System.out.println("输入有误");
					}
						}
					}
				}else{
					System.out.println("输入错误");
				}

			} else if (select == 2) {
				this.register();
			} else if (select == 3) {
				this.forgetpw(c);
			} else {
				System.out.println("指令错误");
			}
		}
	}



	/**
	 * @Title: login
	 * @Description: 获取用户输入的cc号
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	private int login() {
		int account = ui.getInt("请输入您的cc号:");
		return account;
	}

	/**
	 * @Title: clogin
	 * @Description: 客户登陆的方法
	 * @param: @param account
	 * @param: @return
	 * @return: Client
	 * @throws
	 */
	private Client clogin(int account) {
		Client c = tBiz.selectBycac(account);
		String type = null;
		if (c != null) {
			if(c.getCard().getCatype().equals("1")){
				type="vip用户";
			}else if(c.getCard().getCatype().equals("2")){
				type="超级vip用户";
			}else{
				type="普通用户";
			}
			String cpassword = ui.getString("请输入密码:");
			if (cpassword.equals(c.getCpassword())) {
				System.out.println("登陆成功，欢迎" +type+c.getCname());
				return c;
			} else {
				System.out.println("密码错误");
				return null;
			}
		} else {
			System.out.println("您输入的cc号有误！");
			return null;
		}
	}

	/**
	 * @Title: mlogin
	 * @Description: 经理登录
	 * @param: @param account
	 * @param: @return
	 * @return: Manager
	 * @throws
	 */
	private Manager mlogin(int account) {
		Manager m = tBiz.selectBymac(account);
		if (m != null) {
			String mpassword = ui.getString("请输入密码:");
			if (mpassword.equals(m.getMpassword())) {
				System.out.println("登陆成功,欢迎经理" + m.getMname());
				return m;
			} else {
				System.out.println("密码错误");
				return null;
			}
		} else {
			System.out.println("您输入的cc号有误！");
			return null;
		}

	}

	/**
	 * @Title: Qthree
	 * @Description: 获取登陆账号的前三位，并返回
	 * @param: @param account
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	private String Qthree(int account) {
		String a = account + "";
		String b = a.substring(0, 3);
		return b;
	}

	/**
	 * @Title: register
	 * @Description: 注册方法
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void register() {
		String cname = ui.getString("请输入你的名字:");
		String cpassword;
		String csex;
		String email;
		while (true) {
			cpassword = ui.getString("请输入密码:");
			String cpassword2 = ui.getString("请再次输入密码:");
			if (cpassword.equals(cpassword2)) {
				break;
			} else {
				System.out.println("两次输入不一致，请重新输入");
			}
		}
		while (true) {
			csex = ui.getString("请输入您的性别（男/女）:");
			if (csex.equals("男")) {
				break;
			} else if (csex.equals("女")) {
				break;
			} else {
				System.out.println("输入有误!");
			}
		}
		String date = ui.getString("请输入您的出生日期（yyyy-mm-dd）");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cbirth = null;
		try {
			cbirth = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			email = ui.getString("请输入您的QQ邮箱(xxx@qq.com):");
			boolean flag = this.emailflag(email);
			if (flag) {
				Client c = tBiz.selectByemail(email);
				if (c == null) {
					break;
				} else {
					System.out.println("您输入的邮箱已注册");
				}

			} else {
				System.out.println("您输入的邮箱有误，请重新输入。");
			}
		}
		String a = tBiz.cliAndcard(new Client(cpassword, cname, csex, cbirth,
				email));
		System.out.println(a);

	}

	
	
	/**   
	 * @Title: forgetpw   
	 * @Description: 忘记账号或密码    
	 * @param: @param c      
	 * @return: void      
	 * @throws   
	 */
	private void forgetpw(Client cl) {
		int number = (int) ((Math.random() * 9 + 1) * 1000);
		String num = number + "";
		String email;
		Client c;
		while (true) {
			email = ui.getString("请输入您的注册邮箱:");
			if(email.equals(cl.getCemail())){
			boolean flag = this.emailflag(email);
			if (flag) {
				c = tBiz.selectByemail(email);
				if (c != null) {
					e.sendEmail(email, num);
					break;
				} else {
					System.out.println("您输入的注册邮箱不存在在");
				}
			} else {
				System.out.println("邮箱格式错误");
			}
			}else{
				System.out.println("您输入的邮箱不正确");
			}
		}
		while (true) {
			int numm = ui.getInt("请输入四位验证码:");
			if (numm == number) {
				System.out.println("您的cc号为:" + c.getCaccount());
				String newpw = ui.getString("请输入您的新密码:");
				String s = tBiz.updatePass(c.getCaccount(), newpw);
				System.out.println(s);
				break;
			} else {
				System.out.println("验证码错误请重新输入");
			}
		}
		
	}

	/**
	 * @Title: emailflag
	 * @Description: 验证邮箱是否正确的方法
	 * @param: @param email
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean emailflag(String email) {
		String emailW = email.substring(email.length() - 7);
		if (emailW.equals("@qq.com")) {
			return true;
		} else {
			return false;
		}
	}
	

	/**   
	 * @Title: updatepw   
	 * @Description: 修改密码  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void updatepw(Client c) {
		String oldpw = ui.getString("请输入您的旧密码:");
		String newpw;
		if(c.getCpassword().equals(oldpw)){
			while(true){
			 newpw= ui.getString("请输入新密码");
			String newpw2 = ui.getString("再次输入密码:");
			if(newpw.equals(newpw2)){
				break;
			}else{
				System.out.println("两次输入不一致");
			}
			}
			String s = tBiz.updatePass(c.getCaccount(), newpw);
			System.out.println(s);
		}else{
			System.out.println("您输入的密码不正确");
		}
		
	}
	
	

	/**   
	 * @Title: deletteY   
	 * @Description: 删除员工   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void deletteY() {
		int saccount = ui.getInt("请输入要删除的员工编号:");
		Staff s = tBiz.selectBysac(saccount);
		if(s==null){
			System.out.println("您输入的员工不存在");
		}else{
			boolean f = tBiz.deleteSta(saccount);
			if(f){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}
		
	}

	/**   
	 * @Title: updateSpw   
	 * @Description: 员工修改密码   
	 * @param: @param s
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	private String updateSpw(Staff s) {
		String oldpw = ui.getString("请输入您的旧密码:");
		String newpw;
		if(oldpw.equals(s.getSpassword())){
			while(true){
			newpw = ui.getString("请输入新密码:");
			String newpw2 = ui.getString("请再次输入密码:");
			if(newpw.equals(newpw2)){
				break;
			}else{
				System.out.println("两次密码不一致，重新输入");
			}
			}
			String str = tBiz.updatespw(s.getSaccount(), newpw);
			System.out.println(str);
			return newpw;
		}else{
			System.out.println("旧密码错误");
			return s.getSpassword();
		}
		
		
	}

	/**   
	 * @Title: slogin   
	 * @Description: 员工登录  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private Staff slogin(int saccount) {
		Staff s = tBiz.selectBysac(saccount);
		if(s==null){
			System.out.println("您输入的编号不存在");
			return null;
		}
		String spassword = ui.getString("请输入您的密码:");
		if(spassword.equals(s.getSpassword())){
			System.out.println("登陆成功，亲爱的员工"+s.getSname()+"，你好");
			return s;
		}else{
			System.out.println("密码错误");
			return null;
		}
		
		
	}

	/**   
	 * @Title: staffmenu   
	 * @Description: 订单接收   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void staffmenu() {
		List<String> list = tBiz.selectOFid();
		System.out.println("订单编号\t下单时间");
		for (String s : list) {
			String[] arr = s.split("#");
			System.out.println(arr[0]+"\t"+arr[1]);
		}
		String ofid = ui.getString("请输入您要查找的订单（输入z退出）:");
		if("z".equals(ofid)){
			return ;
		}
		Map<String, Integer> map = tBiz.selectByOfid(ofid);
		if(map==null){
			System.out.println("您输入的订单号有误");
		}else{
			System.out.println("菜品名\t下单数量");
			Set<String> keySet = map.keySet();
			for (String str : keySet) {
				System.out.println(str+"\t"+map.get(str));
			}
			
		}
		
	}
	
	/**   
	 * @Title: deleteOf   
	 * @Description: 删除订单  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void deleteOf() {
		String ofid = ui.getString("请输入要删除的订单编号:");
		Map<String, Integer> map = tBiz.selectByOfid(ofid);
		if(map==null){
			System.out.println("订单不存在");
		}else{
			boolean flag = tBiz.deleteByofid(ofid);
			if(flag){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}
		
	}

	/**   
	 * @Title: insertY   
	 * @Description: 添加员工   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void insertY() {
		System.out.println("开始录入员工信息:");
		String sname = ui.getString("请输入员工姓名:");
		String sposition = ui.getString("请输入员工职位:");
		String semail;
		while(true){
		 semail= ui.getString("请输入员工qq邮箱:");
		boolean flag = this.emailflag(semail);
		if(flag){
			break;
		}else{
			System.out.println("邮箱格式不正确");
		}
		}
		int saccount = tBiz.insertSta(new Staff(sname,sposition,semail));
		System.out.println("添加成功，员工编号为"+saccount+"，初始密码为123456");
	}


	/**
	 * @Title: shoeMenu
	 * @Description: 显示菜单
	 * @param:
	 * @return: void
	 * @throws
	 */
	public void showMenu() {
		List<Menu> cheapM = new ArrayList<Menu>();
		List<Menu> coldM = new ArrayList<Menu>();
		List<Menu> hotM = new ArrayList<Menu>();
		List<Menu> mainM = new ArrayList<Menu>();
		List<Menu> soupM = new ArrayList<Menu>();
		List<Menu> menu = tBiz.selectAllMe();
		for (Menu m : menu) {
			if (m.getTypeid() == 1) {
				coldM.add(m);
			} else if (m.getTypeid() == 2) {
				hotM.add(m);
			} else if (m.getTypeid() == 3) {
				mainM.add(m);
			} else if (m.getTypeid() == 4) {
				soupM.add(m);
			} else {
				continue;
			}
			if (m.getMediscount() < 1) {
				cheapM.add(m);
			}
		}
		System.out.println("----------------菜单----------------");
		System.out.println(" ");
		int meid = tBiz.selectIDSalT();
		if(meid!=0){
			System.out.println("              |*本月热销*|");
			Menu m = tBiz.selectBymeid(meid);
			System.out.println(m);
		}
		System.out.println(" ");
		if (cheapM != null) {
			System.out.println("              |*今日特价 *|");
			for (Menu cheap : cheapM) {
				System.out.println(cheap);
			}
		}
		System.out.println(" ");
		System.out.println("                |凉菜 |");
		for (Menu cold : coldM) {
			System.out.println(cold);
		}
		System.out.println(" ");
		System.out.println("                |热菜 |");
		for (Menu hot : hotM) {
			System.out.println(hot);
		}
		System.out.println(" ");
		System.out.println("                |主食 |");
		for (Menu main : mainM) {
			System.out.println(main);
		}
		System.out.println(" ");
		System.out.println("                | 汤  |");
		for (Menu soup : soupM) {
			System.out.println(soup);
		}
	}

	/**
	 * @Title: pickMenu
	 * @Description: 点菜的方法
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void pickMenu(Client c) {
		if (tBiz.selectState(c.getCard().getCaid()).equals("1")) {
			System.out.println("您的卡已挂失不能点菜");
			return;
		}
		boolean f = this.birthD(c);
		String sex = null;
		if (c.getCsex().equals("男")) {
			sex = "先生";
		} else if (c.getCsex().equals("女")) {
			sex = "女士";
		}
		if (f) {
			System.out.println("-----------------------------------------");
			System.out.println("|尊敬的" + c.getCname() + sex
					+ ",生日快乐,今天您在本店消费享受九五折待遇哦！|");
			System.out.println("-----------------------------------------");
			System.out.println(" ");
		}
		this.showMenu();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> key = map.keySet();
		boolean flag = false;

		String menulist = ui.getString("请输入您要点的菜编号(以,隔开。取消点菜输入z):");
		if(menulist.equals("z")){
			return ;
		}
		String[] arr = menulist.split(",");
		for (String s : arr) {
			for (String s2 : key) {
				if (s.equals(s2)) {
					flag = true;
					map.put(s2, map.get(s2) + 1);
					break;
				}
			}
			if (!flag) {
				map.put(s, 1);
			}
		}
		for (String s3 : key) {
			Menu me = tBiz.selectBymeid(Integer.parseInt(s3));
			if (me != null) {
				String s = tBiz.insertShopcar(new ShopCar(me, map.get(s3), c));
				System.out.println(s3 + s);
			} else {
				System.out.println("菜单中没有" + s3 + "号菜品");
			}
		}

	}

	/**
	 * @Title: lookShopcar
	 * @Description: 查看购物车
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private void lookShopcar(Client c) {
		List<ShopCar> list = tBiz.selectMBycac(c.getCaccount());
		System.out.println("您添加的菜品如下:");
		for (ShopCar sc : list) {
			double price = Double
					.parseDouble(new DecimalFormat("#.##").format((sc.getM()
							.getMeprice() * sc.getM().getMediscount())
							* sc.getMenum()));
			System.out.println(sc.getM().getMeid() + " "
					+ sc.getM().getMename() + " " + sc.getMenum() + " " + price
					+ "元");
		}

	}

	/**
	 * @Title: delectMe
	 * @Description: 移除购物车中指定菜品
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private void delectMe(Client c) {
		int meid = ui.getInt("请输入要移除的菜品编号:");
		ShopCar sc = tBiz.selectBymeid(meid, c.getCaccount());
		if (sc != null) {
			System.out.println("您添加的指定菜品信息如下:");
			System.out.println(sc.getM().getMename() + " " + sc.getMenum());
			int menum = ui.getInt("请输入要移除数量:");
			if (menum > sc.getMenum()) {
				System.out.println("您输入的数量有误");
			} else {
				String s = tBiz.deleteMenuS(meid, menum, c.getCaccount());
				System.out.println(s);

			}
		} else {
			System.out.println("您没有添加该菜品");
		}

	}

	/**
	 * @Title: birthD
	 * @Description: 判断今天是否是生日
	 * @param: @param c
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean birthD(Client c) {
		Date d = new Date();
		String date = (d.getMonth() + 1) + "-" + d.getDate();
		String bir = (c.getCbirth().getMonth() + 1) + "-"
				+ c.getCbirth().getDate();
		if (date.equals(bir)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @Title: pay
	 * @Description: 结账
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private void pay(Client c) {
		// boolean flag=false;
		double price = tBiz.addMoney(c.getCaccount());
		Card card = tBiz.selectBycid(c.getCard().getCaid());
		boolean flag = this.birthD(c);
		if (flag) {
			price = Double.parseDouble(new DecimalFormat("#.##")
					.format(price * 0.95));
			System.out.println("今天是您的生日本店为您的消费打九五折");

		}
		System.out.println("您的消费金额为" + price + "元");
		String s = ui.getString("是否确认支付？(y/n)");
		if (s.equals("y")) {
			if (card.getCabalance() > price) {
				double p = tBiz.updateBa(c.getCard().getCaid(), price);
				double in = tBiz.updateInt(c.getCard().getCaid(), price);
				System.out.println("支付成功，您的卡上余额为" + p+"元，本次积分为"+price+",卡上积分为"+in);
				UUID uid = UUID.randomUUID();
				String[] arr = uid.toString().split("-");
				String i = ui.getString("是否打印小票(y/n)?");
				if ("y".equals(i)) {
					this.printTap(c, price,in,arr[2]);
				}
				Map<ShopCar, Double> map = new HashMap<ShopCar, Double>();
				List<ShopCar> list = tBiz.selectMBycac(c.getCaccount());
				for (ShopCar sc : list) {
					map.put(sc, this.addMenuMon(sc.getM(), sc.getMenum(), c));
					tBiz.insertOrderf(arr[2],sc);
					String str = tBiz.deleteMenuS(sc.getM().getMeid(),
							sc.getMenum(), c.getCaccount());
				}
				boolean a = tBiz.insertSales(map);// 添加到月销售账单
			} else {
				System.out.println("您的卡上余额不足");
			}
		} else {
			System.out.println("支付取消");
		}

	}

	/**
	 * @Title: printTap
	 * @Description: 打印小票
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	public void printTap(Client c, double price,double in,String ofid) {
		List<ShopCar> list = tBiz.selectMBycac(c.getCaccount());
 
		System.out.println(" ");
		System.out.println("   想吃自助点餐系统           ");
		System.out.println("------------------");
		System.out.println("cc号:" + c.getCaccount());
		System.out.println("卡号:"+c.getCard().getCaid());
		System.out.println("卡上积分为:"+in);
		
		System.out.println("订单编号:" + ofid);
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(d);
		System.out.println("下单时间:"+date);
		System.out.println("------------------");
		System.out.println("菜名\t数量\t价格");
		for (ShopCar s : list) {
			System.out.println(s.getM().getMename()
					+ "\t"
					+ s.getMenum()
					+ "\t"
					+ (s.getM().getMeprice() * s.getMenum() * s.getM()
							.getMediscount()));

		}
		System.out.println("-------------------");
		double money = tBiz.addMoney(c.getCaccount());
		double discount = tBiz.selectDis(c.getCaccount());
		System.out.println("应付金额:" + Double.parseDouble(new DecimalFormat("#.##").format(money / discount)));
		System.out.println("实付金额:" + price);
	}

	/**
	 * @Title: addMenuMon
	 * @Description: 计算单个菜的利润
	 * @param: @param m
	 * @param: @param num
	 * @param: @return
	 * @return: double
	 * @throws
	 */
	public double addMenuMon(Menu m, int num, Client c) {
		double discount = tBiz.selectDis(c.getCaccount());
		double price = (m.getMeprice() * m.getMediscount() - m.getMepuprice())
				* num * discount;
		return Double.parseDouble(new DecimalFormat("#.##").format(price));

	}

	/**
	 * @Title: cardmoney
	 * @Description: 卡充值
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private void cardmoney(Client c) {
		String state = tBiz.selectState(c.getCard().getCaid());
		if (state.equals("1")) {
			System.out.println("您的卡已挂失不可充值");
			return;
		}
		view.cardAC();
		double price = ui.getDouble("请输入充值金额：");
		double endprice = price;
		if(price>=200){
			endprice=price+50;
			System.out.println("您充值的金额大于200元，将赠送您50元");
		}
		double p = tBiz.cardmoney(c.getCard().getCaid(), endprice);
		System.out.println("充值成功，您的卡上余额为" + p);
		if(price>=300&&price<600){
			boolean flag = tBiz.updateType(c.getCard().getCaid(), "1");
			if(flag){
				System.out.println("您的卡已升级为vip，折扣将成为95折");
			}
		}else if(price>=600){
			boolean flag2 = tBiz.updateType(c.getCard().getCaid(), "2");
			if(flag2){
				System.out.println("您的卡已升级为svip，折扣将成为9折");
			}
		}
	
	}
		

	/**
	 * @Title: dolose
	 * @Description: 卡挂失
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void dolose(Client c) {
		int cid;
		while (true) {
			cid = ui.getInt("请输入您的卡号:");
			if (c.getCard().getCaid() != cid) {
				System.out.println("您输入的卡号不正确");
			} else {
				break;
			}
		}
		String state = tBiz.selectState(cid);
		if (state.equals("1")) {
			System.out.println("您的账号已挂失了");
			return;
		}
		String s = tBiz.dolost(cid);
		System.out.println(s);

	}
	

	/**   
	 * @Title: Mdolose   
	 * @Description: 卡冻结  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void Mdolose() {
		int cid = ui.getInt("请输入要冻结的卡号:");
		Card c = tBiz.selectBycid(cid);
		String type;
		if(c!=null){
			if(c.getCatype().equals("1")){
				type="vip";
			}else if(c.getCatype().equals("2")){
				type="超级vip";
			}else{
				type="普通";
			}
			System.out.println("您要冻结的卡信息如下:");
			System.out.println("卡号\t卡类型");
			System.out.println(c.getCaid()+"\t"+type);
			String s = ui.getString("是否要冻结(y\n):");
			if("y".equals(s)){
				tBiz.dolost(cid);
				System.out.println("冻结成功");
			}else{
				System.out.println("冻结取消");
			}
		}else{
			System.out.println("卡号输入错误");
		}
	
		
	}


	/**
	 * @Title: relieveCard
	 * @Description: 解除挂失
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void relieveCard(Client c) {

		int cid;
		while (true) {
			cid = ui.getInt("请输入您的卡号:");
			if (c.getCard().getCaid() == cid) {
				break;
			} else {
				System.out.println("您输入的不正确");
			}
		}
		String state = tBiz.selectState(cid);
		if (state.equals("0")) {
			System.out.println("您的账号未挂失");
			return;
		}
		String s = tBiz.relieveC(cid);
		System.out.println(s);
	}

	/**
	 * @Title: buildcard
	 * @Description: 补卡
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private Card buildcard(Client c) {
		int cid;
		// System.out.println(c.getCard().getCaid());
		while (true) {
			cid = ui.getInt("请输入您的卡号:");
			if (cid == c.getCard().getCaid()) {
				break;
			} else {
				System.out.println("输入错误重新输入");
			}
		}
		String s = tBiz.selectState(cid);
		if (s.equals("0")) {
			System.out.println("您的卡未挂失不可补办");
			return null;
		}
		Card card = tBiz.buildcard(c.getCard(), c.getCaccount());
		System.out.println("补办成功，您的新卡号为" + card.getCaid());
		return card;

	}

	/**
	 * @Title: selectBa
	 * @Description: 查询余额
	 * @param: @param c
	 * @return: void
	 * @throws
	 */
	private void selectBa(Client c) {
		Card card = tBiz.selectBycid(c.getCard().getCaid());
		System.out.println("您的卡上余额为" + card.getCabalance());

	}
	
	/**   
	 * @Title: selectInt   
	 * @Description: 查询卡积分  
	 * @param: @param c      
	 * @return: void      
	 * @throws   
	 */
	private void selectInt(Client c) {
		double in = tBiz.selectInt(c.getCard().getCaid());
		System.out.println("您的卡上积分为"+in);
		
	}

	/**
	 * @Title: addMenu
	 * @Description: 添加菜品
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void addMenu() {
		int meid;
		while (true) {
			meid = ui.getInt("请输入添加菜品编号:");
			Menu menu = tBiz.selectBymeid(meid);
			if (menu != null) {
				System.out.println("您输入的菜品编号已存在，请重新输入");
			} else {
				break;
			}
		}
		String mename = ui.getString("请输入菜品的名字:");
		double mepuprice = ui.getDouble("请输入菜的进价:");
		double meprice = ui.getDouble("请输入菜的卖价:");
		System.out.println("菜品类型如下：");
		Map<Integer, String> map = tBiz.selectAlltype();
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i + "\t" + map.get(i));
		}
		int typeid = ui.getInt("请输入菜类型编号:");
		double mediscount = ui.getDouble("请输入菜品折扣:");
		String s = tBiz.insertMenu(new Menu(meid, mename, meprice, typeid,
				mediscount, mepuprice));
		System.out.println(s);
	}

	/**
	 * @Title: setDis
	 * @Description: 修改折扣
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void setDis() {
		this.showMenu();
		int meid = ui.getInt("请输入您要修改的菜品编号:");
		Menu me = tBiz.selectBymeid(meid);
		if (me != null) {
			double mediscount = ui.getDouble("请输入您要设置的折扣(0.00):");
			String s = tBiz.updateMenu(meid, mediscount);
			System.out.println(s);
		} else {
			System.out.println("您输入的菜品编号有误");
		}

	}

	/**   
	 * @Title: exportSales   
	 * @Description: 导出excel表  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void exportSales() {
//		String epath = ui.getString("请输入导出位置:");
		String s = tBiz.exportSales();
		if (s!=null) {
			System.out.println("导出成功,导出位置为"+s);
		} else {
			System.out.println("导出失败");
		}

	}
	
	/**   
	 * @Title: findTall   
	 * @Description: 查看月销售量排行   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private void findTall() {
		Date d=new Date();
		int month=(d.getMonth()+1);
		
		Map<String, Integer> map =tBiz.salesTall();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
			Map.Entry<String, Integer> o2) {
			return ( o2.getValue()-o1.getValue());
			}
			});
		System.out.println(month+"月份销售量排行如下:");
		System.out.println("菜名\t月销售量(份)");
		for (int i = 0; i < list.size(); i++) {
			Entry<String,Integer> ent=list.get(i);
			System.out.println(ent.getKey()+"\t"+ent.getValue());
		}
		
	}
	
	/**   
	 * @Title: delectSales   
	 * @Description: 清空上月销售表  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	public void delectSales(){
		
		boolean flag = tBiz.deleteSale();
		if(flag){
			System.out.println("清空成功");
		}else{
			System.out.println("清空失败");
		}
		
	}

}
