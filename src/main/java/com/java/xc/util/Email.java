package com.java.xc.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email {
	public void sendEmail(String reemail,String num) {
		HtmlEmail email = new HtmlEmail();// 创建一个HtmlEmail实例对象
		email.setHostName("smtp.163.com");// 邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
		email.setCharset("utf-8");// 设置发送的字符类型
		try {
			email.addTo(reemail);
			email.setFrom("shenhaizhic@163.com", "深海之城");// 发送人的邮箱为自己的，用户名可以随便填
			email.setAuthentication("shenhaizhic@163.com", "123456zxcv");// 设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
			email.setSubject("验证码");// 设置发送主题
			email.setMsg(num);// 设置发送内容
			email.send();// 进行发送
			System.out.println("发送成功");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 设置收件人
	}
}
