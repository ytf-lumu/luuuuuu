package com.nico.nicoweb.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName SwaggerController
 * @Description  swagger 接口测试
 * @Date 2019/1/17 0017 11:25
 */
@Controller
@RequestMapping("/swagger")
@Api("swagger 测试接口")
public class SwaggerController {

    @ResponseBody
    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String swaggerindex(){
        return  "测试";
    }
    @ResponseBody
    @RequestMapping(value ="/getUserName", method= RequestMethod.GET)
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String getUserName(@RequestParam Integer userNumber){
        if(userNumber == 1){
            return "张三丰";
        }
        else if(userNumber == 2){
            return "慕容复";
        }
        else{
            return "未知";
        }
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        if(userId <= 0 || userId > 2){
            return "未知的用户";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
            return "密码不能为空";
        }
        if(password.equals(newPassword)){
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }

}
