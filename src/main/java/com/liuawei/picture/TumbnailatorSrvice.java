package com.liuawei.picture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

public class TumbnailatorSrvice {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * 设置图片的宽度和高度
		 */
		String source = "resource/images/juan1.jpg";
		int width = 950;
		int height = 950;
		/*
		 * 如果大于原图的宽和高不进行缩放
		 */
		String target1 = "resource/images/awei1.jpg";
		Thumbnails.of(source).size(width, height).toFile(target1);
		/*
		 * 根据宽和高强制缩放
		 */
		String target2 = "resource/images/awei2.jpg";
		Thumbnails.of(source).forceSize(width, height).toFile(target2);
		
		/*
		 * 根据比例缩放，长度和宽度
		 */
		String source3 = "resource/images/test.jpg";
		String target3 = "resource/images/test1.jpg";
		Thumbnails.of(source3).scale(0.2).toFile(target3);
		String target4 = "resource/images/test2.jpg";
		Thumbnails.of(source3).scale(8).toFile(target4);
		String target5 = "resource/images/test3.jpg";
		Thumbnails.of(source).scale(0.6, 0.6).toFile(target5);
		/*
		 * 图片旋转
		 */
		String target6 = "resource/images/awei6.jpg";
		Thumbnails.of(source).scale(1).rotate(90).toFile(target6);
		
		/*
		 * 图片尺寸不变压缩大小
		 */
		String target7 = "resource/images/awei7.jpg";
		Thumbnails.of(source).scale(1).outputQuality(0.8).toFile(target7);
		/*
		 * 添加水印
		 */
		String target8 = "resource/images/awei8.jpg";
		Thumbnails.of(source).scale(1).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("resource/images/test1.jpg")), 0.8f).toFile(target8);
		/*
		 *  图片裁剪
		 */
		String target9 = "resource/images/awei9.jpg";
		String target10 = "resource/images/awei10.jpg";
		Thumbnails.of(source).sourceRegion(50, 80, 100, 130).scale(1).toFile(target9);
		Thumbnails.of(source).sourceRegion(Positions.BOTTOM_LEFT, 100, 200).scale(1).toFile(target10);
		/*
		 *  转换图片格式
		 */
		Thumbnails.of(source).scale(1).outputFormat("png").toFile("resource/images/awei11");
		/*
		 * 通过流写文件
		 */
		String target12 = "resource/images/awei12.jpg";
		OutputStream os = new FileOutputStream(target12);
		Thumbnails.of(source).scale(1).toOutputStream(os);
		os.flush();
		
		String target13 = "resource/images/awei13.jpg";
		String target14 = "resource/images/awei14.jpg";
		BufferedImage  image = Thumbnails.of(source).scale(1).asBufferedImage();
		System.out.println("  height--"+image.getHeight()+"	width--"+image.getWidth()+" type--"+image.getType());
		Thumbnails.of(image).scale(1).toFile(target13);
		image.flush();
		Thumbnails.of(image).scale(1).toFile(target14);

	}	
	
	/**
	 * 裁剪图片--根据File
	 * @param source
	 * @param target
	 * @param width
	 * @param height
	 */
	public void thumbnailByFile(File source,File target,int width,int height) {
		try {
			Thumbnails.of(source).size(width, height).toFile(target);
			System.out.println("生成图片成功--target"+target.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 裁剪图片--根据 path
	 * @param sourcePath
	 * @param targetPath
	 * @param width
	 * @param height
	 */
	public void thumbnailByPath(String sourcePath,String targetPath,int width,int height){
		try {
			Thumbnails.of(sourcePath).size(width, height).toFile(targetPath);
			System.out.println("生成图片成功--target"+targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rotateByPath(String sourcePath,String targetPath,double rotate ){
		try {
			Thumbnails.of(sourcePath).size(500, 500).rotate(rotate).toFile(targetPath);;
			System.out.println("生成图片成功--target"+targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void watermarkByPath(String sourcePath,String targetPath,String watermarkPath,float rotate ){
		try {
			Thumbnails.of(sourcePath).size(1024, 968).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(watermarkPath)), rotate).outputQuality(rotate).toFile(targetPath);;
			System.out.println("生成图片成功--target"+targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
