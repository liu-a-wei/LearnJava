package com.liuawei.Java.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {

	private static int calculateRedAmount(String configStr) {
		String[] config = configStr.split(",");
		List<Integer> redPool = new ArrayList<>();
		String item;
		int redAmount;
		int redWegit;
		for (int i = 0; i < config.length; i++) {
			item = config[i];
			redAmount = Integer.parseInt(item.split("-")[0]);
			redWegit = Integer.parseInt(item.split("-")[1]);
			for (int j = 0; j < redWegit; j++) {
				redPool.add(redAmount);
			}
		}
		Random random = new Random();
		System.out.println(redPool.size());
		return redPool.get(random.nextInt(redPool.size()));
	}
	public static void main(String[] args) {
		for(int i=0;i<40;i++){
			System.out.println(calculateRedAmount("50-11,60-5,70-3,80-1"));
		}
	}
}

class Student {
	String name;
	Integer age;

	public Student(String name, Integer age) {
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
class Interval{
	private Integer left;
	
	private Integer right;
	
	public Interval(Integer left,Integer right){
		this.setLeft(left);
		this.setRight(right);
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public Integer getRight() {
		return right;
	}

	public void setRight(Integer right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Interval [left=" + left + ", right=" + right + "]";
	}
	
}