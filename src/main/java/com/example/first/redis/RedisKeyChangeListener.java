//package com.example.first.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisKeyChangeListener extends KeyChangeEventMsgListener {
//
//    public Logger logger = LoggerFactory.getLogger(RedisKeyChangeListener.class);
//
//    public RedisKeyChangeListener(RedisMessageListenerContainer listenerContainer) {
//        super(listenerContainer);
//    }
//
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        logger.info("监听Redis key ，key：{}，channel：{}", message.toString(), new String(pattern));    }
//}