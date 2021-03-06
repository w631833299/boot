package com.wx.boot.web;

import com.wx.boot.bean.UserInfo;
import com.wx.boot.service.UserInfoService;
import com.wx.boot.util.ControllerTool.CommonController;
import com.wx.boot.util.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:  wx
 * @Description: 用户登录类
 * @Date: 2018/10/17
 * @Version: v1.0
 **/
@RestController
public class LongIn extends CommonController {

    //用户业务类
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录方法
     * @param
     * @return
     */
    @RequestMapping(value = "/ajaxLogin")
    @ResponseBody
    public String ajaxLogin(@RequestBody(required = false) UserInfo userInfo) {
        if(ObjectHelper.isEmpty( userInfo )){
            //测试账号
            userInfo = new UserInfo();
            userInfo.setUsername("wx");
            userInfo.setPassword("123456");//密码明文是123456
        }
        return userInfoService.ajaxLogin(userInfo);
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 没有权限操作，shiro应重定向到错误界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauthorized")
    @ResponseBody
    public Object unauthorized() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "无权限访问");
        return map;
    }
}
