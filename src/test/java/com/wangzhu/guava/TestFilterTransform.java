package com.wangzhu.guava;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class TestFilterTransform {
	private static final Logger logger = LoggerFactory
			.getLogger(TestFilterTransform.class);

	public static void main(String[] args) {

		// filter

		List<String> strList = Lists.newArrayList("apple", "orange", "pear",
				"banana");

		TestFilterTransform.logger.info("iterables filter:{}",
				Iterables.filter(strList, Predicates.containsPattern("p")));

		TestFilterTransform.logger.info("collections2 filter:{}",
				Collections2.filter(strList, Predicates.containsPattern("p")));
		Predicate<String> predicate = new Predicate<String>() {

			public boolean apply(String input) {
				return input.contains("p") && input.startsWith("a");
			}
		};

		TestFilterTransform.logger.info("iterables filter:{}",
				Iterables.filter(strList, predicate));
		TestFilterTransform.logger.info("collections2 filter:{}",
				Collections2.filter(strList, predicate));

		Function<String, Integer> function = new Function<String, Integer>() {

			public Integer apply(String input) {
				return input.length();
			}
		};

		TestFilterTransform.logger.info("transform:{}",
				Collections2.transform(strList, function));

	}
}
