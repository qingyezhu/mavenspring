package com.wangzhu.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TestJoinSplit {

	private static final Logger logger = LoggerFactory
			.getLogger(TestJoinSplit.class);

	private static final String ON_KEY = ",";

	private static final String WITH_KEY = "=";

	public static void main(String[] args) {
		// 将List转化为String
		List<String> strList = Lists.newArrayList("John", "Jane", "Tom", "Ada");
		TestJoinSplit.logger.info("convert list to string:{}",
				Joiner.on(TestJoinSplit.ON_KEY).join(strList));

		// 将String转化为List
		String inputListStr = "apple , banana , orange , pear ";
		TestJoinSplit.logger.info("splist string to list:{}",
				Splitter.on(TestJoinSplit.ON_KEY).splitToList(inputListStr));
		TestJoinSplit.logger.info(
				"splist string to list and trim:{}",
				Splitter.on(TestJoinSplit.ON_KEY).trimResults()
						.splitToList(inputListStr));

		// 将Map转化为String
		Map<String, Integer> map = Maps.newHashMap();
		map.put("1qaz", 123);
		map.put("2wsx", 234);
		map.put("3edc", 345);
		map.put("4rfv", 456);
		TestJoinSplit.logger.info(
				"convert map to string:{}",
				Joiner.on(TestJoinSplit.ON_KEY)
						.withKeyValueSeparator(TestJoinSplit.WITH_KEY)
						.join(map));

		// 将String转化为Map
		String inputMapStr = "1=apple,2=banana,3=orange,4=pear";
		TestJoinSplit.logger.info(
				"split string to map:{} ",
				Splitter.on(TestJoinSplit.ON_KEY)
						.withKeyValueSeparator(TestJoinSplit.WITH_KEY)
						.split(inputMapStr));

		// 多个List之间的Join
		List<ArrayList<String>> nestedList = Lists.newArrayList();
		nestedList.add(Lists.newArrayList("apple", "banana", "orange"));
		nestedList.add(Lists.newArrayList("cat", "dog", "bird"));
		nestedList.add(Lists.newArrayList("java", "php", "c", "pythom",
				"javascript"));
		TestJoinSplit.logger.info(
				"many list join:{}",
				Joiner.on(TestJoinSplit.ON_KEY).join(
						Iterables.transform(nestedList,
								new Function<List<String>, String>() {

									public String apply(List<String> input) {
										return Joiner.on("-").join(input);
									}
								})));

		// 去掉null的join
		List<String> strList1 = Lists.newArrayList("java", null, "php", null,
				null, "c", "pythom");

		TestJoinSplit.logger.info("skip null convert list to string:{}", Joiner
				.on(TestJoinSplit.ON_KEY).skipNulls().join(strList1));
		// null使用默认值替换
		TestJoinSplit.logger.info(
				"user for null convert list to string:{}",
				Joiner.on(TestJoinSplit.ON_KEY).useForNull("NULL")
						.join(strList1));

	}
}
