package com.wangzhu.redis;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis是一个key-value存储系统。和Memcached类似，它支持存储的value类型相对更多，<br/>
 * 包括string(字符串)、list(链表)、 set(集合)、zset(sorted set --有序集合)和hash（哈希类型）。<br/>
 * 这些数据类型都支持push/pop、add/remove及取交集并集和差集及更丰富的操作 ，而且这些操作都是原子性的。<br/>
 * 在此基础上，redis支持各种不同方式的排序。与memcached一样，为了保证效率，数据都是缓存在内存中。<br/>
 * 区别的是redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了master-slave。<br/>
 * 所需jar包：jedis-2.6.2.jar hamcrest-core-1.3.jar junit-4.11.jar<br/>
 * 
 * @author wangzhu
 * @date 2015-3-9上午9:10:16
 * 
 */
public class TestRedis {

	Jedis jedis;
	JedisPool pool;

	@Before
	public void init() {
		pool = new JedisPool(new JedisPoolConfig(), "localhost");
		jedis = pool.getResource();
	}

	@Test
	public void testPing() {
		System.out.println("Servier is runnning: " + jedis.ping());
		// Servier is runnning: PONG
	}

	@After
	public void destroy() {
		jedis.disconnect();
	}

	@Test
	public void testString() {
		// 获取
		System.out.println("get===" + jedis.get("strKey"));

		// 设置
		System.out.println("set===" + jedis.set("strKey", "qingyezhu"));

		// 获取
		System.out.println("get===" + jedis.get("strKey"));

		// 删除
		System.out.println("del===" + jedis.del("strKey"));

		// get===null
		// set===OK
		// get===qingyezhu
		// del===1

	}

	@Test
	public void testList() {
		String listKey = "listKey";
		// System.out.println("lpush==="
		// + jedis.lpush(listKey, "Redis", "MongoDb", "MySql", "Oracle",
		// "Db2"));

		System.out.println("lpush====" + jedis.lpush(listKey, "other"));
		long len = jedis.llen(listKey);
		System.out.println("size===" + len);
		List<String> list = jedis.lrange(listKey, 0, len);
		System.out.println("list====" + list);
		for (int i = 0; i < len; i++) {
			System.out.println(i + "===lindex===" + jedis.lindex(listKey, i));
		}

		System.out.println(jedis.llen(listKey));
	}
}
