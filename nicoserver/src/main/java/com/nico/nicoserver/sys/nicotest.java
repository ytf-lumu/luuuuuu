package com.nico.nicoserver.sys;

import com.nico.nicoserver.entity.YqUser;
import com.nico.nicoserver.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user")
public class nicotest {
    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/edit")
    public List<YqUser> useredit(){
        List<YqUser> list=userRepository.findAllByUserId(2l);
        return list;
    }

    @ResponseBody
    @RequestMapping("/query")
    public List<YqUser> nicotest(){
        List<YqUser> list=userRepository.findAllByUserId(1l);
        return list;
    }
}
