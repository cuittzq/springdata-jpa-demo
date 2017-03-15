package cn.tzq.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhiqiang on 2017/3/15.
 */
@Service
@Transactional
public class RedisTemplateUtils {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisTemplateUtils(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 写入缓存
     *
     * @param key    存入 key
     * @param value  存入 值
     * @param expire 过期时间 秒
     */
    public void set(String key, Object value, Long expire) {
        try {
            redisTemplate.opsForValue().set(key, Gson.class.newInstance().toJson(value), expire, TimeUnit.SECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 读取缓存
     *
     * @param key
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        Object varobj = redisTemplate.boundValueOps(key).get();
        if (varobj == null || varobj.toString().isEmpty()) {
            return null;
        }
        return Gson.class.newInstance().fromJson(varobj.toString(), clazz);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object getObj(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * 删除，根据key精确匹配
     *
     * @param key
     */
    public void del(String... key) {
        redisTemplate.delete(Arrays.asList(key));
    }

    /**
     * 批量删除，根据key模糊匹配
     *
     * @param pattern
     */
    public void delpn(String... pattern) {
        for (String kp : pattern) {
            redisTemplate.delete(redisTemplate.keys(kp + "*"));
        }
    }

    /**
     * key是否存在
     *
     * @param key
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
}
