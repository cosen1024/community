package com.nowcoder.community.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName Event.java
 * @Description 事件，用于消息队列
 * @createTime 2020/5/14 21:19
 */
public class Event {

    private String topic;
    private int userId;
    private int entityType;
    private int entityId;
    //实体的作者
    private int entityUserId;

    /*
    把其他额外的数据，存入map中，具有扩展性
    目的：为了后期动态扩展，有些字段没有办法做出预判
     */
    private Map<String,Object> data=new HashMap<>();

    public String getTopic() {
        return topic;
    }

    /*
    此处这样设计，是为了更灵活的设置属性，避免使用多个构造函数。
    这样设计很灵活和方便
     */
    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key,Object value) {
        this.data.put(key,value);
        return this;
    }
}
