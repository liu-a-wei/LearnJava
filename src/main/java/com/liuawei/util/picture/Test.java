package com.liuawei.util.picture;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		TumbnailatorSrvice service = HandlePitchure.HandlePitchureByTumbnailator();
//		service.thumbnailByFile(new File("resource/images/juan2.jpg"),new File("resource/images/awei1.jpg"),500,500);
//		service.thumbnailByPath("resource/images/juan2.jpg","resource/images/awei1.jpg",500,500);
//		service.rotateByPath("resource/images/juan2.jpg","resource/images/awei1.jpg",45);
		service.watermarkByPath("resource/images/juan2.jpg","resource/images/awei2.jpg","resource/images/juan3.jpg",0.8f);
	}

}
