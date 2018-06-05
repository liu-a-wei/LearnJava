package com.liuawei.Java.base;

import java.io.IOException;

public class RunTimeDemo {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("jvm总共内存" + run.totalMemory());
		System.out.println("jvm最大内存" + run.maxMemory());
		System.out.println("jvm空闲内存" + run.freeMemory());
		System.out.println("可用进程" + run.availableProcessors());
		System.out.println();
		
		try {
			Process process = run.exec("cmd");
			System.out.println("执行命令!"+process.toString());
			System.out.println("isAlive!"+process.isAlive());
			process.waitFor();
			process.destroy();
			System.out.println("isAlive!"+process.isAlive());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
