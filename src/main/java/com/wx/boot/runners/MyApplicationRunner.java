package com.wx.boot.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 项目启动完成后执行特定方法及任务
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/8
 * @Auther: wangxiang
 */
@Component
@Order(value = 1) //设置启动顺序
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.printf( "=======================启动成功==============================" );
    }
}
