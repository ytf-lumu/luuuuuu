package com.nico.nicoweb.sys;

import com.nico.nicoweb.vo.MenuChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName MenuServer
 * @Description TODO
 * @Date 2019/1/15 0015 14:36
 */
@Controller
@RequestMapping("/menu")
public class MenuServer {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index(){
        return "menu/menuindex";
    }

    @ResponseBody
    @RequestMapping("/indexdata")
    public List<MenuChildren> indexdata(){
        List<MenuChildren> list = restTemplate.getForEntity("http://localhost:8900/menu/query", List.class).getBody();
        return list;
    }
}
