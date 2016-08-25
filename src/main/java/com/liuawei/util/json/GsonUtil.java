package com.liuawei.util.json;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;


import com.google.gson.reflect.TypeToken;

public final class GsonUtil {

	/**
	 * 转化为list对象
	 */
	public final static Type CONVERT_JSON_LISTS_ENTITY = new TypeToken<Collection<Class<?>>>() {}.getType();

	/**
	 * 转化为array对象
	 */
	public final static Type CONVERT_JSON_ARRAYS_ENTITY = new TypeToken<Class<?> []>() {}.getType();
	
	/**
	 * 转化为map对象
	 */
	public final static Type CONVERT_JSON_MAP_ENTITY = new TypeToken<Map<Class<?>, Class<?>>>() {}.getType();
	
	
	Type getListEntity(Class<?> clazz){
		return new TypeToken<Collection<Class<?>>>() {}.getType();
	}

}
