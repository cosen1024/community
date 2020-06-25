package com.nowcoder.community;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName CommunityServeltInitalizer.java
 * @Description 自定义tomcat 启动入口
 * @createTime 2020/6/25 20:39
 */
public class CommunityServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CommunityApplication.class);
    }
}
