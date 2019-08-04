package com.wsn.conference.submission.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * K: 指以hash结构操作时,键类型
 * T: 为数据实体应实现序列化接口,并定义serialVersionUID * RedisTemplate,提供了五种数据结构操作类型 hash / list / set / zset / value
 * 方法命名格式为: 数据操作类型 + 操作 如 hashPut 指以hash结构(也就是map)key添加键值对
 * @author leyao
 * @version 2018-9-14
 */
public interface RedisService<K, T> {
    /**
     * Hash结构：添加元素
     * @param key
     * @param hashKey
     * @param domain
     */
    void hashPut(String key, K hashKey, T domain);

    /**
     * Hash结构：返回指定key对应hashmap所有键值对
     * @param key
     * @return
     */
    Map<K, T> hashGetAll(String key);

    /**
     * Hash结构：返回指定key对应hashmap指定键的值
     * @param key
     * @param hashKey
     * @return
     */
    T hashGet(String key, K hashKey);

    /**
     * Hash结构：删除指定key对应hashmap指定键的值
     * @param key
     * @param hashKey
     */
    void hashRemove(String key, K hashKey);

    /**
     * List结构：向key对应列表尾部添加新元素
     * @param key
     * @param domain
     * @return
     */
    Long listLastPush(String key, T domain);

    /**
     * List结构：向key对应列表头部添加新元素
     * @param key
     * @param domain
     * @return
     */
    Long listHeadPush(String key, T domain);

    /**
     * List结构：获取key对应列表的全部内容
     * @param key
     * @return
     */
    List<T> listGetAll(String key);

    /**
     * List结构：移除并获取列表第一个元素
     * @param key
     * @return
     */
    T listHeadPop(String key);

    /**
     * String结构：将对象直接设为key的value
     * @param key
     * @param domain
     */
    void valuePut(String key, T domain);

    /**
     * String结构：返回key对应的value对象
     * @param key
     * @return
     */
    T getValue(String key);

    /**
     * String结构：删除key对应的value对象
     * @param key
     */
    void removeValue(String key);

    /**
     * 过期时间：为某一键key设置过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    boolean expire(String key, long timeout, TimeUnit timeUnit);
}
