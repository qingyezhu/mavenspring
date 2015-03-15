package com.wangzhu.aop;

import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.stereotype.Component;

@Component
public class StringUtils {

	private static Logger logger = Logger.getLogger(StringUtils.class);
	private static final int LEN = 100000;

	@Profiled
	public void testAdd() {
		int len = StringUtils.LEN;
		String ret = "";
		for (int i = 0; i < len; i++) {
			final String s = Integer.toString(i);
			ret += s;
		}
	}

	@Profiled
	public void testConcat() {
		int len = StringUtils.LEN;
		String ret = "";
		for (int i = 0; i < len; i++) {
			final String s = Integer.toString(i);
			ret = ret.concat(s);
		}
	}

	@Profiled
	public void testStringBuilder() {
		int len = StringUtils.LEN;
		StringBuilder accum = new StringBuilder();
		for (int i = 0; i < len; i++) {
			final String s = Integer.toString(i);
			accum.append(s);
		}
	}

}
