package com.nowcoder.community.controller;

import com.nowcoder.community.service.DataService;
import org.apache.kafka.common.network.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName DataController.java
 * @Description 数据统计 Controller
 * @createTime 2020/5/20 21:41
 */

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 统计页面
    @RequestMapping(path = "/data",method = {RequestMethod.GET,RequestMethod.POST})
    public String getDataPage(){
        return "/site/admin/data";
    }

    // 统计网站UV
    @RequestMapping(path = "/data/uv",method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model){
        long uv = dataService.calculateUV(start, end);
        model.addAttribute("uvResult",uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);

        // 此处与return "/site/admin/data"一样，只不过目前通过转发，可以复用getDataPage方法。这个也是getDataPage方法的method = {RequestMethod.GET,RequestMethod.POST}的原因，因为要接受来自getUV的request（为post方式）
        return "forward:/data";
    }

    // 统计活跃用户
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long dau = dataService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);
        return "forward:/data";
    }
}
