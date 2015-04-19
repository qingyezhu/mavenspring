package com.wangzhu.guava;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class TestGuavaMap {
	private static final Logger logger = LoggerFactory
			.getLogger(TestGuavaMap.class);

	public static void main(String[] args) {

		Map<String, Integer> integerMap = Maps.newHashMap();

		Map<String, Integer> integerMap1 = ImmutableMap
				.<String, Integer> builder().put("abc", 1).put("eol", 12)
				.put("!@#", 112).build();
	}

}
