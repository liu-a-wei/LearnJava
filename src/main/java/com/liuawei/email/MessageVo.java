package com.liuawei.email;

/**
 * 消息模板
 * 
 * @author liuawei
 * 
 */
public class MessageVo {

	private String subject;
	private String text;
	private String toMailAddress;
	private String image;
	private String attach;

	/**
	 * 获取主题
	 * 
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置主题
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取文本内容
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 设置文本内容
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 获取收件人地址
	 * 
	 * @return
	 */
	public String getToMailAddress() {
		return toMailAddress;
	}

	/**
	 * 设置收件人地址
	 * 
	 * @param toMailAddress
	 */
	public void setToMailAddress(String toMailAddress) {
		this.toMailAddress = toMailAddress;
	}

	/**
	 * 获取图片
	 * 
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * 设置图片
	 * 
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 获取附件
	 * 
	 * @return
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * 设置附件
	 * 
	 * @param attach
	 */
	public void setAttach2(String attach) {
		this.attach = attach;
	}
}
