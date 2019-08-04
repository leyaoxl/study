// package com.wsn.conference.submission.config;
//
// import com.fasterxml.jackson.annotation.JsonAutoDetect;
// import com.fasterxml.jackson.annotation.PropertyAccessor;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.cache.CacheManager;
// import org.springframework.cache.annotation.CachingConfigurerSupport;
// import org.springframework.cache.interceptor.KeyGenerator;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.cache.RedisCacheManager;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
// import org.springframework.data.redis.serializer.StringRedisSerializer;
//
// import java.lang.reflect.Method;
// import java.util.logging.Logger;
//
// /**
//  * @author leyao
//  * @version 2018-9-6
//  */
// @Configuration
// public class RedisConfig extends CachingConfigurerSupport {
//     private Logger logger = Logger.getLogger(RedisConfig.class.getName());
//
//     @Value("${spring.redis.host}")
//     private String host;
//
//     @Value("${spring.redis.port}")
//     private int port;
//
//     @Value("${spring.redis.timeout}")
//     private String timeout;
//
//     @Value("${spring.redis.password}")
//     private String password;
//
//     @Value("${spring.redis.database}")
//     private int database;
//
//     @Value("${spring.redis.jedis.pool.max-idle}")
//     private int maxIdle;
//
//     @Value("${spring.redis.jedis.pool.min-idle}")
//     private int minIdle;
//
//     /**
//      * 注解@Cache 自定义key生成规则
//      * @return
//      */
//     @Bean
//     public KeyGenerator keyGenerator() {
//         return new KeyGenerator() {
//             @Override
//             public Object generate(Object target, Method method, Object... params) {
//                 // 格式化缓存key字符串
//                 StringBuilder stringBuilder = new StringBuilder();
//                 // 追加类名
//                 stringBuilder.append(target.getClass().getName());
//                 // 追加方法名
//                 stringBuilder.append(method.getName());
//                 //遍历参数并且追加
//                 for (Object obj : params) {
//                     stringBuilder.append(obj.toString());
//                 }
//                 logger.info("===== 调用Redis生成key: " + stringBuilder.toString() + " ===== leyao =====");
//                 return stringBuilder.toString();
//             }
//         };
//     }
//
//     /**
//      * 采用RedisCacheManager作为缓存管理器
//      * @param factory
//      * @return
//      */
//     @Bean
//     public CacheManager cacheManager(RedisConnectionFactory factory) {
//         // 设置Redis键生存时间为7天
//         RedisCacheManager redisCacheManager = RedisCacheManager.create(factory);
//         return redisCacheManager;
//     }
//
//     @Bean
//     public RedisTemplate<Object, Object> redisTemplate(
//             // 客户端链接
//             RedisConnectionFactory factory) {
//         /**
//          * RedisTemplate以及StringRedisTemplate（数据操作模板）
//          * StringRedisTemplate只针对key和value都是string的数据进行操作
//          * RedisTemplate模板默认采用JdkSerializationRedisSerializer的二进制数据序列化方式
//          * 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//          * 使用StringRedisSerializer来序列化和反序列化redis的key值
//          */
//         RedisTemplate<Object, Object> template = new RedisTemplate();
//         template.setConnectionFactory(factory);
//
//         // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//         Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//
//         ObjectMapper om = new ObjectMapper();
//         om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//         om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//         jackson2JsonRedisSerializer.setObjectMapper(om);
//
//         template.setValueSerializer(jackson2JsonRedisSerializer);
//         // 使用StringRedisSerializer来序列化和反序列化redis的key值
//         template.setKeySerializer(new StringRedisSerializer());
//         template.afterPropertiesSet();
//         return template;
//     }
//
// }
