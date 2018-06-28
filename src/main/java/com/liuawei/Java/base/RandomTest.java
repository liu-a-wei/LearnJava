package com.liuawei.Java.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(random2.nextInt(2));
		}
		
		
		Integer i = 1;
		int j = (int) (i.floatValue()/100);
		System.out.println(j);
		List<Student> list = new ArrayList<>();
		Student student = null;
		student = new Student("xliu1", 15);
		list.add(student);
		student = new Student("xliu2", 1);
		list.add(student);
		student = new Student("xliu3", 2);
		list.add(student);
		student = new Student("xliu4", 12);
		list.add(student);
		
		int freeBase = (int) 250 / 100;
		int temp = 0;
		int left,right,prizeWeight;
		List<Map<String, Object>> mapList = new ArrayList<>();
		Map<String, Object> map = null;
		for (Student student2 : list) {
			//免单红包权重不处理
			if (freeBase<=0) {
				prizeWeight = student2.getAge();
			}else{
				prizeWeight = student2.getAge()*freeBase;
			}
			left = temp;
			right = left + prizeWeight -1;
			temp = right;
			map = new HashMap<>();
			map.put("id", student2.getName());
			map.put("interval", new Interval(left,right));
			mapList.add(map);
			++temp;
		}
		Random random = new Random();
		int num = random.nextInt(temp);
		Interval interval = null;
		for (Map<String, Object> map2 : mapList) {
			System.out.println(map2);
		}
		System.out.println(temp);
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