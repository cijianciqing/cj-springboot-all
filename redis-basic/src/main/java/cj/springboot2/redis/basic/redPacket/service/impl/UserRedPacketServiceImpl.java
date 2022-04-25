package cj.springboot2.redis.basic.redPacket.service.impl;



import cj.springboot2.redis.basic.redPacket.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRedPacketServiceImpl  implements UserRedPacketService {

    @Autowired
    private RedisTemplate redisTemplate;

    /*
     * 使用redis
     * 更改：使用redis+lua
     速度   7.058 seconds
     *     * */
    public Long grapRedPacketByRedis(Long redPacketId, Long userId) {
        // Lua脚本
        String script =
                "local redPacketKey = KEYS[1] \n" //定义 红包的key
                + "local userKey = KEYS[2] \n"    //定义 用户key
                + "local stock = tonumber(redis.call('get', redPacketKey)) \n" //获取 红包的库存数
                + "if stock <= 0 then return 0 end \n"//返回值为0：代表没有库存
                /*
                *   红包总库存-1
                *   将最新的库存会写到redis
                *   红包的用户，红包数量 +1
                * */
                + "stock = stock -1 \n"
                + "redis.call('set', redPacketKey, stock) \n"
                + "redis.call('incr', userKey) \n"
                + "if stock == 0 then return 2 end \n"//返回值如果等于2，从redis写入数据库
                + "return 1 \n";//返回值为1： 继续抢红包

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keys = new ArrayList<>();
        keys.add("redPacket"+redPacketId);//k1
        keys.add("user"+userId);//k2
        Long result = (Long)redisTemplate.execute(redisScript, keys);
        System.out.println("result : "+ result);
        return result;
    }


}
