package com.phy.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClusterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		// Jedis Cluster will attempt to discover cluster nodes automatically
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7000));
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7001));
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7002));
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7003));
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7004));
		// jedisClusterNodes.add(new HostAndPort("192.168.201.100", 7005));

		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7000));
		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7001));
		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7002));
		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7003));
		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7004));
		jedisClusterNodes.add(new HostAndPort("192.168.201.99", 7005));

		JedisCluster jc = new JedisCluster(jedisClusterNodes);
		jc.set("foo", "bar");// 不设置超时
		jc.setex("foo", 1800, "bar");// 设置1800s超时

		System.out.println(jc.get("foo"));
	}

}
