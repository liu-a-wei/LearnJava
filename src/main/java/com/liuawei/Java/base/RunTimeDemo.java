package com.liuawei.Java.base;

public class RunTimeDemo {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("jvm总共内存" + run.totalMemory());
		System.out.println("jvm最大内存" + run.maxMemory());
		System.out.println("jvm空闲内存" + run.freeMemory());
		System.out.println("jvm空闲内存" + run.availableProcessors());
	}
}
