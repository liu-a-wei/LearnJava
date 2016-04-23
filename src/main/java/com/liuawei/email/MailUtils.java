package com.liuawei.email;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public final class MailUtils {
	
	private static Session session = null;
	/**
	 * 获取 session 实例
	 * @return
	 */
	public static Session getInstance() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", MailConfig.protocol);
		props.setProperty("mail.smtp.host", MailConfig.host);
		props.setProperty("mail.smtp.port", MailConfig.port);
		props.setProperty("mail.smtp.auth", MailConfig.isAuth);
		props.setProperty("mail.smtp.username", MailConfig.username);
		props.setProperty("mail.smtp.password", MailConfig.password);
		props.setProperty("mail.smtp.from", MailConfig.from);
		session = null;
		session = Session.getInstance(props);
		return session;
	}

	/**
	 * 发送邮件
	 * @param msg
	 */
	public static void sendMail(Message msg) {
		try {
			Transport ts = session.getTransport();
			ts.connect(MailConfig.username, MailConfig.password);
			ts.sendMessage(msg, msg.getAllRecipients());
			ts.close();
			System.out.println("发送成功");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建简单的邮件
	 * @param session
	 * @param mv
	 * @return
	 */
	public static Message createSimpleMail(Session session,MessageVo mv){
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(MailConfig.from));
			msg.setRecipient(RecipientType.TO, new InternetAddress(mv.getToMailAddress()));
			msg.setSubject(mv.getSubject());
			msg.setContent(mv.getText(), "text/html;charset=utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 创建带附件的邮件
	 * @param session
	 * @param mv
	 * @return
	 */
	public static Message   createAttachMail(Session session,MessageVo mv){
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(MailConfig.from));
			msg.setRecipient(RecipientType.TO, new InternetAddress(mv.getToMailAddress()));
			msg.setSubject(mv.getSubject());
			//创建邮件正文
			MimeBodyPart text = new MimeBodyPart();
			text.setContent("使用JavaMail创建带附件的邮件","text/html;charset=UTF-8");
			//创建邮件附件
			MimeBodyPart attach = new MimeBodyPart();
			DataHandler dh = new DataHandler(new FileDataSource(mv.getAttach()));
			attach.setDataHandler(dh);
			attach.setFileName(dh.getName());
			//创建容器描述数据关系
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(text);
			mp.addBodyPart(attach);
			mp.setSubType("mixed");
			//保存Multipart数据
			msg.setContent(mp);
			msg.saveChanges();
			//将文件备份到本地
			msg.writeTo(new FileOutputStream("E:\\attachMail.eml"));
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
