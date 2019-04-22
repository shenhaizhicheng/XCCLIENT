package com.java.xc.biz;

import com.java.xc.domain.Manager;

public interface managerBiz {
	//根据cc号(账户名)查找经理信息
    public  Manager selectBymac(int maccount);
}
