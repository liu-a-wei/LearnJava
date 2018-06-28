package com.liuawei.Java.io;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileDemo {

	public static void main(String[] args) throws IOException{
		File file = new File("D:\\liuaweiio");
		file.mkdir();
	}
	
	/**
	 * 遍历文件夹路径
	 * @param path
	 * @param depPath
	 * @throws IOException
	 */
	public static void getFile(String path,int depPath) throws IOException{
		File file = new File(path);
		if(!file.exists()){
			Objects.requireNonNull(file);
		}
		if (file.isFile()) {
			System.out.print("--|");
			System.out.println(file.getName());
		}else {
			for (int i = 0; i < depPath; i++) {
				System.out.print("  ");
			}			
			System.out.print("--|");
			System.out.println(file.getName());
			String [] fileArr = file.list();
			int currentPath = depPath +1;
			for (int i = 0; i < fileArr.length; i++) {
				File dirFile = new File(file.getCanonicalPath(),fileArr[i]);
				if(dirFile.isDirectory()){
					getFile(dirFile.getCanonicalPath(),currentPath);
				}else {
					for (int j = 0; j < currentPath; j++) {
						System.out.print("  ");
					}
					System.out.print("--|");
					System.out.println(dirFile.getName());
				}
			}
		}
	}
}
