package com.wsn.conference.submission.service.serviceImpl;

import com.wsn.conference.submission.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class RedisServiceImpl<K, T> implements RedisService<K, T> {
    private Logger logger = Logger.getLogger(RedisServiceImpl.class.getName());
    // 在构造器中获取redisTemplate实例, key(not hashKey) 默认使用String类型
    private RedisTemplate<String, T> redisTemplate;
    // 在构造器中通过redisTemplate的工厂方法实例化操作对象
    private HashOperations<String, K, T> hashOperations;
    private ListOperations<String, T> listOperations;
    private SetOperations<String, T> setOperations;
    private ZSetOperations<String, T> zSetOperations;
    private ValueOperations<String, T> valueOperations;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.setOperations = redisTemplate.opsForSet();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     * Hash结构：添加元素
     * @param key
     * @param hashKey
     * @param domain
     */
    @Override
    public void hashPut(String key, K hashKey, T domain) {
        hashOperations.put(key, hashKey, domain);
    }

    /**
     * Hash结构：返回指定key对应hashmap所有键值对
     * @param key
     * @return
     */
    @Override
    public Map<K, T> hashGetAll(String key) {
        return hashOperations.entries(key);
    }

    /**
     * Hash结构：返回指定key对应hashmap指定键的值
     * @param key
     * @param hashKey
     * @return
     */
    @Override
    public T hashGet(String key, K hashKey) {
        return hashOperations.get(key, hashKey);
    }

    /**
     * Hash结构：删除指定key对应hashmap指定键的值
     * @param key
     * @param hashKey
     */
    @Override
    public void hashRemove(String key, K hashKey) {
        hashOperations.delete(key, hashKey);
    }

    /**
     * List结构：向key对应列表尾部添加新元素
     * @param key
     * @param domain
     * @return
     */
    @Override
    public Long listLastPush(String key, T domain) {
        return listOperations.rightPush(key, domain);
    }

    /**
     * List结构：向key对应列表头部添加新元素
     * @param key
     * @param domain
     * @return
     */
    @Override
    public Long listHeadPush(String key, T domain) {
        return listOperations.leftPush(key, domain);
    }

    /**
     * List结构：获取key对应列表的全部内容
     * @param key
     * @return
     */
    @Override
    public List<T> listGetAll(String key) {
        return listOperations.range(key, 0, listOperations.size(key));
    }

    /**
     * List结构：移除并获取列表第一个元素
     * @param key
     * @return
     */
    @Override
    public T listHeadPop(String key) {
        return listOperations.leftPop(key);
    }

    /**
     * String结构：将对象直接设为key的value
     * @param key
     * @param domain
     */
    @Override
    public void valuePut(String key, T domain) {
        valueOperations.set(key, domain);
    }

    /**
     * String结构：返回key对应的value对象
     * @param key
     * @return
     */
    @Override
    public T getValue(String key) {
        return valueOperations.get(key);
    }

    /**
     * String结构：删除key对应的value对象
     * @param key
     */
    @Override
    public void removeValue(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 过期时间：为某一键key设置过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }
}
