package com.wx.boot.redis;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: TODO 请用一句话说明作用
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/9/21
 * @Auther: wangxiang
 */
public class Receiver {

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        System.err.println("Received <" + message + ">");
        latch.countDown();
    }

}
