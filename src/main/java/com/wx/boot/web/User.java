package com.wx.boot.web;

import com.wx.boot.util.ControllerTool.AuthorizedController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Description: 用户业务处理类
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/8
 * @Auther: wangxiang
 */
@RestController
public class User extends AuthorizedController {

    @RequestMapping(value = "/test")
    @RequiresPermissions("user_test")
//    @ReturnMapping1(mapping="/test",exclude="user_test")
    public String test() {
        return "访问成功";
    }

    @RequestMapping(value = "/register")
    @RequiresPermissions("user_register")
    public String register(){
        return "2222";
    }

    public static void main(String[] args) {
        //比较两个字符串地址大小
        System.out.println( "2".compareTo( "1" )+"");
        int[] array1 = new int[] { 7, 8, 3, 12, 6, 3, 5, 4};
        Arrays.sort( array1 );
        for (int i = 0 ; i<array1.length;i++){
            System.out.print( array1[i]+"" );
        }
        System.out.println( "" );
        //10 x 2  后面的是位移倍数，如0表示一倍为10，1表示两倍20,3表示三倍40
        int n1 = 10<<1;
        System.out.println( "10<<1为" + n1 );

        //10 / 2【带符号，+或-】
        int n2 = 10>>1;
        System.out.println( "10>>1为" + n2 );

        //10 / 2 不带符号
        int n3 = 10>>>1;
        System.out.println( "10>>>1为" + n3 );

    }
}
