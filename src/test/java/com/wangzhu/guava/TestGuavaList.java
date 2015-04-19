package com.wangzhu.guava;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class TestGuavaList {

	private static Logger logger = LoggerFactory.getLogger(TestGuavaList.class);

	/**
	 * 新建列表List
	 * 
	 * @param arr
	 * @return
	 */
	public static <T> List<T> createArrayList(T... arr) {

		List<T> list = Lists.newArrayList(arr);
		return list;
	}

	/**
	 * 删除列表中的null项，是否更改源列表
	 * 
	 * @param list
	 * @param isChange
	 * @return
	 */
	public static <T> List<T> removeNullFromList(List<T> list, boolean isChange) {
		if (isChange) {
			TestGuavaList.removeNullFromList(list);
			return null;
		}
		return Lists.newArrayList(Iterables.filter(list, Predicates.notNull()));
	}

	/**
	 * 从列表List中删除null值
	 * 
	 * @param list
	 */
	public static <T> void removeNullFromList(List<T> list) {
		Iterables.removeIf(list, Predicates.isNull());
	}

	/**
	 * 反转列表
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> reverse(List<T> list) {
		List<T> reverseList = Lists.reverse(list);
		TestGuavaList.logger.info("reverse from {} to{} ", list, reverseList);
		return reverseList;
	}

	/**
	 * 创建不可更改的列表List
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> createImmutableList(List<T> list) {

		// ImmutableList.builder().addAll(list).build();
		return ImmutableList.copyOf(list);
	}

	public static <T> void testClass(T... arr) {
		List<T> list = TestGuavaList.createArrayList(arr);
		TestGuavaList.logger.info("create list:{}", list);
		List<T> notNullList = TestGuavaList.removeNullFromList(list, false);
		TestGuavaList.logger.info("remove null list:{},{}", list, notNullList);
		if (notNullList != null) {
			list = notNullList;
		}
		List<T> reverseList = TestGuavaList.reverse(list);
		TestGuavaList.logger.info("reverseList:dest{} source{}", reverseList,
				list);

		List<T> newList = TestGuavaList.createImmutableList(list);
		TestGuavaList.logger.info("new immutable list:{}", newList);

	}

	public static void main(String[] args) {
		TestGuavaList.logger.info("TestGuavaList start");
		TestGuavaList.testClass('a', 'b', 'c', 'd', null);
		TestGuavaList
				.testClass(1, 3, 5, null, 7, 10, 111, null, 123, -11, null);
		TestGuavaList.logger.info("TestGuavaList end");

		List<Character> characterList = Lists.charactersOf("qingyezhu");
		TestGuavaList.logger.info("characterList:{}", characterList);

		Random random = new Random();
		int len = 10;
		Person[] personArr = new Person[len];
		for (int i = 0; i < len; i++) {
			personArr[i] = new Person(random.nextInt(100), "name" + i, i & 1,
					random.nextInt(100));
		}
		List<Person> personList = Lists.newArrayList(personArr);

		TestGuavaList.printList(personList);

		// personList = null;
		Optional<List<Person>> personListField = Optional
				.fromNullable(personList);

		Preconditions.checkState(personListField.isPresent(),
				"presonList must not be null");

		// 谓词Predicate与筛选Filter
		TestGuavaList.printList(ImmutableList.copyOf(Collections2.filter(
				personList, new Predicate<Person>() {

					public boolean apply(Person input) {
						return input.getSex() == 0;
					}
				})));

		// 转化transform
		TestGuavaList.printList(ImmutableList.copyOf(Lists.transform(
				personList, new Function<Person, String>() {

					public String apply(Person input) {
						return input.getName();
					}

				})));

		// 排序
		TestGuavaList.printList(new Ordering<Person>() {

			@Override
			public int compare(Person left, Person right) {
				int age = left.getAge() - right.getAge();
				if (age == 0) {
					return left.getId() - right.getId();
				}
				return age;
			}

		}.immutableSortedCopy(personList));

	}

	private static <T> void printList(List<T> list) {
		for (T t : list) {
			TestGuavaList.logger.info("{}", t);
		}
		TestGuavaList.logger.info("\n");
	}

	static class Person {
		private int id;
		private String name;
		private int sex;
		private int age;

		public Person(int id, String name, int sex, int age) {
			this.id = id;
			this.name = name;
			this.sex = sex;
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "{id=" + id + ", name=" + name + ", sex=" + sex + ", age="
					+ age + "}";
		}

	}
}
