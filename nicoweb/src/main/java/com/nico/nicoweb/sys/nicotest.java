package com.nico.nicoweb.sys;

import com.nico.nicoweb.entity.YqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName nicotest
 * @Description TODO
 * @Date 2019/1/3 0003 10:53
 */
@Controller
public class nicotest {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/nico")
    public String nicomain(){
       return "nicomain.html";
    }

    @RequestMapping(value = "/xsll/www", method = RequestMethod.GET)
    public String xsll() {
        return "xsll/www";
    }

    @ResponseBody
    @RequestMapping(value = "/xsll/body")
    public List<YqUser> toIndex(Model model){
        List<YqUser> msg=restTemplate.getForEntity("http://localhost:8900/user/query",List.class).getBody();
        model.addAttribute("msg",msg);
        //System.out.println("------->"+msg.toString());
        return msg;
    }

    @RequestMapping(value = "/wdserver", method = RequestMethod.GET)
    public String uiindex(){
        return "swagger-ui.html";
    }
}
