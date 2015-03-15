package com.wangzhu.quartz;

import org.apache.log4j.Logger;

public class QuartzJob {

	private static final Logger logger = Logger.getLogger(QuartzJob.class);

	public void work() {
		QuartzJob.logger.info("QuartzJob work");
	}
}
