package com.nowcoder.community.controller.interceptor;

import ch.qos.logback.core.net.HardenedObjectInputStream;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DataService;
import com.nowcoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName DataInterceptor.java
 * @Description 数据统计  Interceptor
 * @createTime 2020/5/20 21:35
 */

@Component
public class DataInterceptor implements HandlerInterceptor {

    @Autowired
    private DataService dataService;

    @Autowired
    private HostHolder hostHolder;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统计UV
        String ip = request.getRemoteHost();
        dataService.recordUV(ip);

        // 统计DAU
        User user = hostHolder.getUser();
        if(user!=null){
            dataService.recordDAU(user.getId());
        }
        return true;
    }
}
