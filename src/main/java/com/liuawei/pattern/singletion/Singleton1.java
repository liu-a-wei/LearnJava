package com.liuawei.pattern.singletion;

/**
 * 
 * 单例模式
 * 
 * @author liuawei
 *
 */
public class Singleton1 {

	private static volatile Singleton instance;

	/**
	 * 重新默认构造方法
	 */
	private Singleton() {

	}

	/**
	 * 懒加载
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
