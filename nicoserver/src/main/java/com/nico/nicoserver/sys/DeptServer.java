package com.nico.nicoserver.sys;

import com.nico.nicoserver.entity.YqDept;
import com.nico.nicoserver.mapper.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName DeptServer
 * @Description TODO
 * @Date 2019/1/7 0007 9:58
 */
@Controller
@RequestMapping("/dept")
public class DeptServer {
    @Autowired
    DeptRepository deptRepository;

    @ResponseBody
    @RequestMapping("/query")
    public List<YqDept> queryDept() {
        List<YqDept> list = deptRepository.findByDeptId(101l);
        return list;
    }

    @ResponseBody
    @RequestMapping("/count")
    public Long deptcount(){
       Long count = deptRepository.count();
       return count;
    }
}
