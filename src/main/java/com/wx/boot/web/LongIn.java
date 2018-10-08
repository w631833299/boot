package com.wx.boot.web;

import com.alibaba.fastjson.JSONObject;
import com.wx.boot.bean.UserInfo;
import com.wx.boot.enums.ENUM_EXCEPTION;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LongIn {

    /**
     * 登录方法
     * @param
     * @return
     */
    @RequestMapping(value = "/ajaxLogin")
    @ResponseBody
    public String ajaxLogin() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wx");
        userInfo.setPassword("123456");//密码明文是123456
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg",ENUM_EXCEPTION.E10000.msg);
        } catch (IncorrectCredentialsException e) {
//            e.printStackTrace();
            jsonObject.put("msg",ENUM_EXCEPTION.E10001.msg);
        } catch (LockedAccountException e) {
//            e.printStackTrace();
            jsonObject.put("msg",ENUM_EXCEPTION.E10002.msg);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            jsonObject.put("msg",ENUM_EXCEPTION.E10003.msg);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("msg",ENUM_EXCEPTION.E10004.msg);
        }
        return jsonObject.toString();
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
}
