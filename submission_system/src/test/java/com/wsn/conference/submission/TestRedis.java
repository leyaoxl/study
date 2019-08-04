// package com.wsn.conference.submission;
//
// import com.wsn.conference.submission.entity.Notice;
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.StringRedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import javax.annotation.Resource;
// import java.util.Date;
// import java.util.concurrent.TimeUnit;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class TestRedis {
//     @Autowired
//     private StringRedisTemplate stringRedisTemplate;
//
//     @Resource(name = "redisTemplate")
//     private RedisTemplate redisTemplate;
//
//     @Test
//     public void test() throws Exception {
//         stringRedisTemplate.opsForValue().set("aaa", "111");
//         Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//     }
//
//     @Test
//     public void testObj() throws Exception {
//         Notice notice = new Notice(1L, "ok", "lalalala", new Date(), new Date());
//         ValueOperations<String, Notice> valueOperations = redisTemplate.opsForValue();
//         valueOperations.set("mytestobj", notice);
//         // 设置过期时间是10s
//         valueOperations.set("mytestobj_other", notice, 10, TimeUnit.SECONDS);
//         Thread.sleep(1000);
//         boolean exists = redisTemplate.hasKey("mytestobj_other");
//         if (exists) {
//             System.out.println("exists is true");
//         }
//         else System.out.println("exists is false");
//     }
// }
