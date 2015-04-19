package com.wangzhu.guava;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class TestGuavaSet {
	private static final Logger logger = LoggerFactory
			.getLogger(TestGuavaSet.class);

	/**
	 * ��������Set
	 * 
	 * @param t
	 * @return
	 */
	public static <T> Set<T> createSet(T... t) {
		return Sets.newHashSet(t);
	}

	/**
	 * ����----�ϼ�
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> Set<T> unionSet(Set<T> first, Set<T> second) {
		return Sets.union(first, second);
	}

	/**
	 * �ѿ�����
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> Set<List<T>> cartesianProductSet(Set<T> first,
			Set<T> second) {
		return Sets.cartesianProduct(ImmutableList.of(first, second));
	}

	/**
	 * ����-����
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> Set<T> intersectionSet(Set<T> first, Set<T> second) {
		return Sets.intersection(first, second);
	}

	private static <T> void printSet(T t) {
		TestGuavaSet.logger.info(t.toString());
	}

	public static void main(String[] args) {
		Set<String> sets = TestGuavaSet.createSet("abc", "efg", "134", "@!#");
		TestGuavaSet.printSet(sets);

		Set<Character> first = ImmutableSet.of('a', 'b', 'c', 'd');
		Set<Character> second = ImmutableSet.of('1', 'b', '2', 'd', '3', '4');

		// �ϼ�
		TestGuavaSet.printSet(TestGuavaSet.unionSet(first, second));

		// ����
		TestGuavaSet.printSet(TestGuavaSet.intersectionSet(first, second));

		// �ѿ�����
		TestGuavaSet.printSet(Iterables.transform(
				TestGuavaSet.cartesianProductSet(first, second),
				new Function<List<Character>, String>() {

					public String apply(List<Character> input) {
						return Joiner.on(" ").join(input);
					}
				}));

	}
}
