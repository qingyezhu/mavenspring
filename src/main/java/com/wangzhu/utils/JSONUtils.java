package com.wangzhu.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class JSONUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getFromJson(String source, String... keys) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		JSONObject obj = new JSONObject(source);
		if (obj == null) {
			return null;
		}
		JSONObject data = null;
		for (int i = 0, len = keys.length; i < len; i++) {
			Object value = obj.get(keys[i]);
			if (i == (len - 1)) {
				return (T) value;
			}
			if (value == null) {
				return null;
			}
			data = (JSONObject) value;
			obj = data;
		}
		return null;
	}
}
