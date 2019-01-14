package com.nico.nicoweb.sys;

import com.nico.nicoweb.entity.YqDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName DeptServer
 * @Description TODO
 * @Date 2019/1/7 0007 10:22
 */
@Controller
@RequestMapping("/dept")
public class DeptServer {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/body")
    public String deptquery(){
        return "dept/dept";
    }

    @ResponseBody
    @RequestMapping(value = "/deptall", method = RequestMethod.GET)
    public Map deptContext(){
       List<YqDept> list = restTemplate.getForEntity("http://localhost:8900/dept/query", List.class).getBody();
        Long count = restTemplate.getForEntity("http://localhost:8900/dept/count", Long.class).getBody();
        System.out.println("dept-count------>"+count);
        Map map = new HashMap();
        map.put("dept", list);
        map.put("count", count);
       return map;
    }
}
