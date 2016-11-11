package com.liuawei.util.json;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonBigDecimalConverter implements JsonSerializer<BigDecimal>, JsonDeserializer<BigDecimal> {

	public JsonElement serialize(BigDecimal src, Type typeOfSrc, JsonSerializationContext context) {
		if(src == null){
			return new JsonPrimitive(new BigDecimal("0"));
		}else{
			return new JsonPrimitive(src);
		}
	}

	public BigDecimal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return json.getAsJsonPrimitive().getAsBigDecimal();
	}
}