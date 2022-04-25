package cj.springboot2.redis.basic.lua;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CJRedisLuaTest {

    @Autowired
    private RedisTemplate redisTemplate;

    String sha1 = null;

    public Long test(Long redPacketId, Long userId) {
        // Lua脚本
        String script = "local userKey = KEYS[2] \n"
                + "local redPacketKey = KEYS[1] \n"
                + "local stock = tonumber(redis.call('get', redPacketKey)) \n"
                + "if stock <= 0 then return 0 end \n"//返回值为0： 库存清空
                + "stock = stock -1 \n"
                + "redis.call('set', redPacketKey, stock) \n"
                + "redis.call('incr', userKey) \n"
                + "if stock == 0 then return 2 end \n"//返回值如果等于2，从redis写入数据库
                + "return 1 \n";//返回值为1： 继续抢红包

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keys = new ArrayList<>();
        keys.add("hb"+redPacketId);//k1
        keys.add("us"+userId);//k2
        Long result = (Long)redisTemplate.execute(redisScript, keys);
        System.out.println("result : "+ result);
        return result;
    }

}
