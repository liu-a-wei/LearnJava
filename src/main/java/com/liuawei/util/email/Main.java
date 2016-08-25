package com.liuawei.util.email;

import javax.mail.Message;
import javax.mail.Session;

public class Main {

	public static void main(String[] args) {
		test2();
	}
	public static void test2() {
		/*
		 * 获取session
		 */
		Session session = null;
		session = MailUtils.getInstance();
		//创建邮件内容
		MessageVo mv = new MessageVo();
		mv.setSubject("第一份带附件的测试邮件");
		mv.setText("非常高兴，非常激动\n终于搞定了");
		mv.setToMailAddress("liu928624@126.com");
		mv.setAttach2("C:\\Users\\liuawei\\Desktop\\学习\\1.1首页.png");
		//创建邮件对象
		Message msg = MailUtils.createAttachMail(session, mv);
		//发送邮件
		MailUtils.sendMail(msg);
	}
	
	public static void test1() {
		/*
		 * 获取session
		 */
		Session session = null;
		session = MailUtils.getInstance();
		//创建邮件内容
		MessageVo mv = new MessageVo();
		mv.setSubject("第一份测试邮件");
		mv.setText("非常高兴，非常激动");
		mv.setToMailAddress("liu928624@126.com");
		//创建邮件对象
		Message msg = MailUtils.createSimpleMail(session, mv);
		//发送邮件
		MailUtils.sendMail(msg);
	}

}
