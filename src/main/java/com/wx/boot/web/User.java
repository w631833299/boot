package com.wx.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO 请用一句话说明作用
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/8
 * @Auther: wangxiang
 */
@RestController
public class User {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "访问成功";
    }

}
