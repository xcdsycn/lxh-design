package com.lxh.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisExample {

	public static void main(String[] args) {
	    try (Jedis jedis = new Jedis("127.0.0.1", 6379)){
            String setResult = jedis.set("hello", "world");
            System.out.println(setResult);
            String value = jedis.get("hello");
            System.out.println(value);

            Long counter = jedis.incr("counter");
            System.out.println(counter);
            // hash
            jedis.hset("myhash","f1","v1");
            jedis.hset("myhash","f2","v2");
            Map<String, String> myhash = jedis.hgetAll("myhash");
            System.out.println(myhash);
            // list
            jedis.rpush("mylist","1");
            jedis.rpush("mylist","2");
            jedis.rpush("mylist","3");
            List<String> mylist = jedis.lrange("mylist", 0, -1);
            System.out.println(mylist);
            // set
            jedis.sadd("myset","a");
            jedis.sadd("myset","b");
            jedis.sadd("myset","a");
            Set<String> myset = jedis.smembers("myset");
            System.out.println(myset);
            // zset
            jedis.zadd("myzset",99,"tom");
            jedis.zadd("myzset",66,"peter");
            jedis.zadd("myzset",33,"james");
            Set<Tuple> myzset = jedis.zrangeWithScores("myzset", 0, -1);
            System.out.println(myzset);
        } catch (Exception e) {
	        e.printStackTrace();
        }
	}
}
