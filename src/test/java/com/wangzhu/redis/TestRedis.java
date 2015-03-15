package com.wangzhu.redis;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis��һ��key-value�洢ϵͳ����Memcached���ƣ���֧�ִ洢��value������Ը��࣬<br/>
 * ����string(�ַ���)��list(����)�� set(����)��zset(sorted set --���򼯺�)��hash����ϣ���ͣ���<br/>
 * ��Щ�������Ͷ�֧��push/pop��add/remove��ȡ���������Ͳ�����ḻ�Ĳ��� ��������Щ��������ԭ���Եġ�<br/>
 * �ڴ˻����ϣ�redis֧�ָ��ֲ�ͬ��ʽ��������memcachedһ����Ϊ�˱�֤Ч�ʣ����ݶ��ǻ������ڴ��С�<br/>
 * �������redis�������ԵİѸ��µ�����д����̻��߰��޸Ĳ���д��׷�ӵļ�¼�ļ��������ڴ˻�����ʵ����master-slave��<br/>
 * ����jar����jedis-2.6.2.jar hamcrest-core-1.3.jar junit-4.11.jar<br/>
 * 
 * @author wangzhu
 * @date 2015-3-9����9:10:16
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
		// ��ȡ
		System.out.println("get===" + jedis.get("strKey"));

		// ����
		System.out.println("set===" + jedis.set("strKey", "qingyezhu"));

		// ��ȡ
		System.out.println("get===" + jedis.get("strKey"));

		// ɾ��
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
