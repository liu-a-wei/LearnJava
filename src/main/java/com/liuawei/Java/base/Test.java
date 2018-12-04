package com.liuawei.Java.base;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		File zipFile = null;
		File dirs = null;
		Set<String> machineZip = new HashSet<>();
		machineZip.add("D:\\mnt\\temp\\qrcode\\51803883");
		machineZip.add("D:\\mnt\\temp\\qrcode\\51803886");
		for (String path : machineZip) {
			// 删除压缩文件
			zipFile=new File(path+".zip");
			if (zipFile.exists()&&zipFile.isFile()) {
				zipFile.delete();
			}
			// 删除目录
			dirs = new File(path);
			if (dirs.exists()&&dirs.isDirectory()) {
				File[] dirFiles =  dirs.listFiles();
				for (File file : dirFiles) {
					file.delete();
				}
				dirs.delete();
			}
		}
			
//		List<Map<String, Object>> mapList = new ArrayList<>();
//		Map<String, Object> map = null;
//		map = new HashMap<>();
//		map.put("id", 1);
//		map.put("key", "value");
//		mapList.add(map);
//		map = new HashMap<>();
//		map.put("id", 2);
//		map.put("key", "value2");
//		mapList.add(map);
//		int[] arr = mapList.stream().mapToInt(m->{
//			return (int) m.get("id");
//		}).toArray();
//
//		System.out.println(arr[0]+""+arr[1]);
//		
//		
//		
//		
//		
//		
//		
//		
//
//		String str1 = "普付宝微信";
//		String str2 = "威富通微信";
//		String str3 = "微信";
//		
//		if (str1.contains(str2)) {
//			System.out.println(str1.contains(str2));
//		}
//		if (str3.contains(str2)) {
//			System.out.println(str3.contains(str2));
//		}
//		if (str2.contains(str3)) {
//			System.out.println("str2.contains(str3)");
//		}
	}

}
