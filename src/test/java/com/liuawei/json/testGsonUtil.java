package com.liuawei.json;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liuawei.json.modle.Student;

public class testGsonUtil {

	public static void main(String[] args) {

		Student s1 = new Student(1, 2, "liu", "宝安西乡", new Time(System.currentTimeMillis()));
		List<Student> list1 = new LinkedList<>();
		list1.add(s1);
		list1.add(s1);
		list1.add(s1);
		Student[] arr1 = { s1, s1, s1 };
		Map<Integer, Student> map1 = new HashMap<>();
		map1.put(1, s1);
		map1.put(2, s1);
		map1.put(3, s1);
		Gson gson = new Gson();
		// 对象 -- json
		String entityJson = gson.toJson(s1);
		System.out.println("对象 -- json:" + entityJson);
		// json -- 对象
		System.out.println("对象 -- json:" + gson.fromJson(entityJson, Student.class).toString());
		// list对象 -- json
		String list1Json = gson.toJson(list1);
		System.out.println("json -- list:" + list1Json);
		// json -- list
		List<Student> list2 = gson.fromJson(list1Json, new TypeToken<Collection<Student>>() {
		}.getType());
		for(Student student : list2){
			System.out.println(student.toString());
		}
		// array对象 -- json
		String arr1Json = gson.toJson(arr1);
		System.out.println("json -- array:" + arr1Json);
		// json -- list
		Student[] arr2 = gson.fromJson(list1Json, new TypeToken<Student[]>() {
		}.getType());
		for(Student student : arr2){
			System.out.println(student.toString());
		}
		//map集合 -- json
		String map1Json = gson.toJson(map1);
		System.out.println("json -- map:" + map1Json);
		// json -- list
		HashMap<Integer, Student> map2 = gson.fromJson(map1Json, new TypeToken<Map<Integer, Student>>() {
		}.getType());
		for(Integer key : map2.keySet()){
			System.out.println(map2.get(key).toString());
		}
		
	}

}
