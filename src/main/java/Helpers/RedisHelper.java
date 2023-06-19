package Helpers;

import redis.clients.jedis.Jedis;

public class RedisHelper {
    public void CreateConnection() {
        try {
            Jedis jedis = new Jedis("redis://:mservice@172.16.9.129:6379/0");
            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());
        }catch(Exception e) {
            System.out.println(e);
        }

    }
}
