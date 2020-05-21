package com.nowcoder.community.util;

import java.util.Date;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName Redis.java
 * @Description Redis Key 生成工具
 * @createTime 5/9/2020 3:54 PM
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PREFIX_USER_LIKE = "like:user";
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";

    //验证码
    private static final String PREFIX_KAPTCHA = "kaptcha";

    //登录凭证
    private static final String PREFIX_TICKET = "ticket";
    private static final String PREFIX_USER = "user";

    // 网站数据统计
    private static final String PREFIX_UV = "uv";
    private static final String PREFIX_DAU = "dau";

    private static final String PREFIX_POST = "post";


    //某个实体收到的赞，如帖子，评论
    //like:entity:entityType:entityId -> set(userId) 对应set，存入userId
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + entityType + SPLIT + entityId;
    }

    //某个用户收到的总赞数
    //like:user:userId ->int
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    //某个用户关注的实体
    //followee:userId:entityType ->zset(entityId,date),用有序集合存，存的是关注的哪个实体，分数是当前时间。
    //为了后期统计方便，统计关注了哪些，进行排序列举
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    //某个实体拥有的粉丝，实体可能是用户，或者是帖子
    //follower:entityType:entityId ->zset(userId,date)，存入用户Id
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityType;
    }

    //登录验证码
    //owner是指随机生成的uuid
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    // 登录的凭证
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }

    // 用户
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }

    // 单日uv
    public static String getUVKey(String date) {
        return PREFIX_UV + SPLIT + date;
    }

    // 区间UV
    public static String getUVKey(String startDate, String endData) {
        return PREFIX_UV + SPLIT + startDate + SPLIT + endData;
    }

    // 单日DAU
    public static String getDAUKey(String date) {
        return PREFIX_DAU + SPLIT + date;
    }

    // 区间DAU
    public static String getDAUKey(String startDate, String endDate) {
        return PREFIX_DAU + SPLIT + startDate + SPLIT + endDate;
    }

    // 帖子分数
    public static String getPostScoreKey() {
        return PREFIX_POST + SPLIT + "score";
    }
}
