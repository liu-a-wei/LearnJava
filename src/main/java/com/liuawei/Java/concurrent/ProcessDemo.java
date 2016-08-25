package com.liuawei.Java.concurrent;

import java.io.IOException;
import java.util.Scanner;

public class ProcessDemo {

	public static void main(String[] args) throws IOException {
		processBuilderTest();
		execRuntimeTest();
	}

	public static void processBuilderTest() throws IOException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig/all");
		Process process = pb.start();
		Scanner scanner = new Scanner(process.getInputStream());

		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}
	public static void execRuntimeTest() throws IOException {
	    String cmd = "cmd "+"/c "+"ipconfig/all";
	    Process process = Runtime.getRuntime().exec(cmd);
	    Scanner scanner = new Scanner(process.getInputStream());
	     
	    while(scanner.hasNextLine()){
	        System.out.println(scanner.nextLine());
	    }
	    scanner.close();
	}

}
