package com.liuawei.email;

/**
 * 邮件服务器的配置信息
 * @author liuawei
 *
 */
public final class MailConfig {
	//服务器地址
    final static String host = "smtp.163.com";
    //服务器端口
    final static String port = "25";
    //
    final static String isAuth = "true";
    //用户名
	final static String username = "liu928624@163.com";
	//密码
    final static String password = "zliu282672848...";
    //是否开启SLL
    final static String isSSL = "true";
    //发送邮箱
    final static String from = "liu928624@163.com";
    //时长
    final static String timeout = "36000";
    // 邮箱协议
    final static String protocol = "smtp";
}
