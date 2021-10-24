package com.boge.pibackend.utils;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUtils {
    public static void main(String[] args) {
        //connect to remote redis service
        Jedis jedis = new Jedis("120.78.146.114",6379);
        // If redis has a password, run the following code
        // jedis.auth("123456");
        System.out.println("连接成功");
        //check if redis is running
        System.out.println("服务正在运行: "+jedis.ping());
        //set redis string data
        jedis.set("runoobkey", "www.runoob.com");
        //get stored data and output
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
//        System.out.println("redis 存储成功，用时 "+1.3+"s");
//        List<String> aaa=set("2");
//        Jedis jedis = new Jedis("120.78.146.114",6379);
        List<String> data = jedis.lrange("22", 0, -1 );
        System.out.println(data.size());
        for(String i:data){
            System.out.println(i);
        }
    }

    public static void set(String user_id, List<String> data){
        Jedis jedis = new Jedis("120.78.146.114",6379);
        for(String str:data)
        {
            jedis.lpush(str.split("-")[0], str.split("-")[1]);
        }
    }
    public static List<String> set(String user_id)
    {
        Jedis jedis = new Jedis("120.78.146.114",6379);
        List<String> data = jedis.lrange(user_id, 0, -1 );
        return data;
    }
}
