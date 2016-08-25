package com.liuawei.util.json.model;

import java.sql.Time;


public class Student {
	private int id;
	private double age;
	private String name;
	private String location;
	private Time birthday;
	public Student(int id, double age, String name, String location, Time birthday) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.location = location;
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Time getBirthday() {
		return birthday;
	}
	public void setBirthday(Time birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", location=" + location + ", birthday=" + birthday + "]";
	}
	
	
}
