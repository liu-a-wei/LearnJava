package com.liuawei.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonStringConverter implements JsonSerializer<String>, JsonDeserializer<String> {



	public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
		if(typeOfSrc==String.class){
			if(src == null){
				return new JsonPrimitive("");
			}else{
				return new JsonPrimitive(src.toString());
			}
		}else{
			return new JsonPrimitive(src.toString());
		}

	}
	
	public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return json.getAsJsonPrimitive().getAsString();
	}

}