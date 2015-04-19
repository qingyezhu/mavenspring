package com.wangzhu.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class TestMongoDB {
	private static final Logger logger = LoggerFactory
			.getLogger(TestMongoDB.class);
	private Mongo mongo;

	private DB db;

	@Before
	public void init() {
		try {
			mongo = new Mongo("192.168.1.103", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		db = mongo.getDB("test");
	}

	@After
	public void destroy() {
		if (mongo != null) {
			mongo.close();
		}
	}

	private DBCollection getDBConnetion(String name) {
		return db.getCollection(name);
	}

	@Test
	public void testQuery() {
		DBCollection collection = this.getDBConnetion("user");

		TestMongoDB.logger.info("find");
		this.print(collection.find());

		TestMongoDB.logger.info("find(uid:2)");
		this.print(collection.find(new BasicDBObject("uid", 2)));
	}

	private void print(DBCursor cursor) {
		TestMongoDB.logger.info("-------start---------");
		while (cursor.hasNext()) {
			TestMongoDB.logger.info("{}", cursor.next());
		}
		TestMongoDB.logger.info("-------end---------");
	}

	@Test
	public void testInsert() {

		DBCollection collection = this.getDBConnetion("user");

		DBObject user = new BasicDBObject();
		user.put("uid", 3);
		user.put("age", 43);
		user.put("name", "NULL");
		collection.insert(user);

		String[] nameArr = { "LiLi", "WangSan", "ZhouHong", "NieFen", "HuYan",
				"ZhuSi" };
		Random random = new Random();
		List<DBObject> list = new ArrayList<DBObject>();
		for (int i = 4; i < 20; i++) {
			user = new BasicDBObject();
			user.put("uid", i);
			user.put("age", i * random.nextInt(20));
			user.put("name", nameArr[i % 5]);
			list.add(user);
		}
		collection.insert(list);
	}
}
