package com.liuawei.util.json;

import java.util.ArrayList;

public class testList {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("25");
		list1.add("35");
		list1.add("45");
		System.out.print(list1.toString());
		String list1ARR = list1.toString().replace("[", "").replace("]", "").replace(" ", "");
		System.out.println(list1ARR);
	}

}
