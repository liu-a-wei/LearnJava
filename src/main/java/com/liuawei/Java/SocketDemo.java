package com.liuawei.Java;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket client = new Socket("http://test.lerke.cn:9876", 9876);
		System.out.println(client.getInetAddress());
		
	}
}
