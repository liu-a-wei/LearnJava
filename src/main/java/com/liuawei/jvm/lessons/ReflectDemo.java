package com.liuawei.jvm.lessons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void target(int i) {
		new Exception("#" + i).printStackTrace();
	}
	
	public static void target2(int i) {
		// 不执行任何代码跟踪反射的开销
	}
	
	public static void target3(int i) {
		// 不执行任何代码跟踪反射的开销
	}
	
	private static void pulluteProfile() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method1 = ReflectDemo.class.getMethod("target2", int.class);
		Method method2 = ReflectDemo.class.getMethod("target2", int.class);
		
		if (method1==method2) {
			System.out.println("method1==method2");
		}
		
		if (method1.equals(method2)) {
			System.out.println("method1.equals(method2)");
		}
		
		for (int i = 0; i < 2000; i++) {
			method1.invoke(null, 0);
			method2.invoke(null, 0);
		}
		
	}

	public static void main(String[] args) throws Exception {

		testV5();
	}
	
	/**
	 * -Dsun.reflect.noInflation=true
	 * -Djava.lang.Integer.IntegerCache.high=128
	 * @throws Exception
	 * 341.6
	 */
	public static void testV5() throws Exception{
		Class<?> clazz = Class.forName("com.liuawei.jvm.lessons.ReflectDemo");
		Method method = clazz.getMethod("target2", int.class);
		method.setAccessible(true);
		
		// 打扰内联 逃逸分析不起作用
		pulluteProfile();
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			if (i%100000000==0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp-current);
				current = temp;
			}
			method.invoke(null, 128);
		}
	}
	
	/**
	 * -Dsun.reflect.noInflation=true
	 * @throws Exception
	 * 297.6
	 */
	public static void testV4() throws Exception{
		Class<?> clazz = Class.forName("com.liuawei.jvm.lessons.ReflectDemo");
		Method method = clazz.getMethod("target2", int.class);
		method.setAccessible(true);
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			if (i%100000000==0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp-current);
				current = temp;
			}
			method.invoke(null, 128);
		}
	}
	
	/**
	 * -Djava.lang.Integer.IntegerCache.high=128
	 * 动态构造 参数 
	 * 357.6
	 * @throws Exception
	 */
	public static void testV3() throws Exception{
		Class<?> clazz = Class.forName("com.liuawei.jvm.lessons.ReflectDemo");
		Method method = clazz.getMethod("target2", int.class);
		Object[] arg = new Object[1];
		arg[0] = 128;
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			if (i%100000000==0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp-current);
				current = temp;
			}
			method.invoke(null, arg);
		}
	}

	
	/**
	 * 执行结果318
	 * @throws Exception
	 */
	public static void testV2() throws Exception{
		Class<?> clazz = Class.forName("com.liuawei.jvm.lessons.ReflectDemo");
		Method method = clazz.getMethod("target2", int.class);
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			if (i%100000000==0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp-current);
				current = temp;
			}
			method.invoke(null, 128);
		}
	}
	
	
	/**
	 * java 默认15次   16次后采用动态实现
	 * @throws Exception
	 */
	public static void testV1() throws Exception{
		Class<?> clazz = Class.forName("com.liuawei.jvm.lessons.ReflectDemo");
		Method method = clazz.getMethod("target", int.class);
		for (int i = 0; i < 20; i++) {
			method.invoke(null, i);
		}
	}

}
