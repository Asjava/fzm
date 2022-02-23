package com.fzm.zookeeper.restful.controller;

import com.fzm.zookeeper.restful.bean.Student;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@RefreshScope
public class ZookeeperController {
    @Value("${text.info:text}")
    private String info;

    @RequestMapping(value = "/test")
    public Map<String,Object> test() {
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("info", info);
        return resultMap;
    }

    @RequestMapping(value = "/testData")
    public Map<String,Object> testData(@RequestParam(value = "date", required = false)
                                       @DateTimeFormat(pattern = "yyyy-HH-mm HH:mm:ss") Date date1)
    {
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("data", date1);
        return resultMap;
    }

    /**
     * 直接接受地址url上的参数和form-data数据
     * @param date1
     * @return
     */
    @RequestMapping(value = "/testData1")
    public Date testData1(@RequestParam(value = "date", required = false)
                                       @DateTimeFormat(pattern = "yyyy-HH-mm HH:mm:ss") Date date1)
    {
        return date1;
    }

    /**
     * 只能接受post+body中的参数
     * @param student
     * @return
     */
    @RequestMapping(value = "/requestBody")
    public Student requestBody(@RequestBody Student student)
    {
        return student;
    }

    /**
     * param参数+form-data表单数据接受到对象中
     * @param student
     * @return
     */
    @RequestMapping(value = "/obj")
    public Student obj(Student student,@RequestParam(value = "otherName", required = false) String otherName)
    {
        student.setOtherName(otherName);
        return student;
    }
}
