package com.example.demo.dataObject.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisDO {
    @Value("ip")
    private String ip;
    @Value("port")
    private int port;

    private final JedisPool jedisPool;

    public RedisDO(){
        jedisPool = new JedisPool(ip,port);
    }

    private RuntimeSchema<ShopDO> schema = RuntimeSchema.createFrom(ShopDO.class);

    public ShopDO getShopDO(int shopDOId){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "shopDO:"+shopDOId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null){
                    ShopDO shopDO = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,shopDO,schema);
                    return shopDO;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String putShopDO(ShopDO shopDO){
        try {
            Jedis jedis = jedisPool.getResource();

            try {
                String key = "shopDO:"+shopDO.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(shopDO,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60*60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
