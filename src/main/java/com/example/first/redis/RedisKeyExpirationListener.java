//package com.example.first.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
//
//    public Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);
//
//    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
//        super(listenerContainer);
//    }
//
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        // 拿到key
//        logger.info("监听Redis key过期，key：{}，channel：{}", message.toString(), new String(pattern));
//    }
//}