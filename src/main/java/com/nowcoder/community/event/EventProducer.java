package com.nowcoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName EventProducer.java
 * @Description 事件生产者
 * @createTime 2020/5/14 21:32
 */

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Event event){
        // 将事件发送到指定主题，其中把内容转换为json对象，消费者受到json后，可以将json转换成Event
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}
