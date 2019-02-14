package com.phy.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisDemo {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.201.95", 6379);
		jedis.auth("123456");
		System.out.println("Connection to server successfully");
		System.out.println("Server is running:" + jedis.ping());

		System.out.println("String实例");
		// String 实例
		jedis.set("w3ckey", "Redis tutorial");
		System.out.println(jedis.get("w3ckey"));

		System.out.println("List实例");
		// List实例
		// Redis中以栈结构存储
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "mysql");
		jedis.lpush("tutorial-list", "hadoop");

		List<String> list = jedis.lrange("tutorial-list", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis::" + list.get(i));
		}

		System.out.println("Keys实例");
		// Keys实例
		Set<String> keySet = jedis.keys("*");
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
