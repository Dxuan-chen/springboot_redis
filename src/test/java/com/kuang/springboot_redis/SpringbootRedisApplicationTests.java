package com.kuang.springboot_redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuang.springboot_redis.pojo.User;
import com.kuang.springboot_redis.util.RedisUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

//    @Disabled
    @Test
    void contextLoads() {

        // redisTemplate    操作不同的数据类型，api和我们的指令是一样的
        // opsForValue()    操作字符串  类似String
        // opsForList()     操作List  类似List
        // opsForSet()
        // opsForHash()
        // opsForZSet()
        // opsForGeo()
        // opsForHyperLogLog()
        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，
        //比如，事务，和基本的CRUD

        //获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("mykey","kuangshen");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }

    @Disabled
    @Test
    public void test02() throws JsonProcessingException {
        //真实的开发一般都使用json来传递对象
        User user = new User("狂神",3);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

    @Disabled
    @Test
    public void test03(){
        redisUtil.set("name","kuangshen");
        System.out.println(redisUtil.get("name"));
    }

}
