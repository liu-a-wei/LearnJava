package com.liuawei.pattern.singletion;

/**
 * 
 * 鍗曚緥妯″紡
 * 
 * @author liuawei
 *
 */
public class Singleton1 {

	private static volatile Singleton1 instance;

	/**
	 * 閲嶆柊榛樿鏋勯�犳柟娉�
	 */
	private Singleton1() {

	}

	/**
	 * 鎳掑姞杞�
	 * @return
	 */
	public static Singleton1 getInstance() {
		if (instance == null) {
			synchronized (Singleton1.class) {
				if (instance == null) {
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
}
