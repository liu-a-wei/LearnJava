package com.liuawei.util.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import net.sf.json.util.NewBeanInstanceStrategy;

public class PropTest {
	
	static Properties properties = null;
	static{
		properties = new Properties();
		try{
			properties.load(new InputStreamReader(PropTest.class.getClassLoader().getResourceAsStream("system.properties"), "utf-8"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		System.out.println(properties.getProperty("str"));
	}
}
