package com.wx.boot.web;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Description: 百度身份证识别
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/16
 * @Auther: wangxiang
 */
public class Sample {
    //设置APPID/AK/SK
    // 百度云控制台地址 http://console.bce.baidu.com/ai/?fromai=1#/ai/ocr/report/index~appId=573964  手机号短信登录 15223771042
    public static final String APP_ID = "14448641";
    public static final String API_KEY = "b7j2buzYmjGbu35kfMTW7vas";
    public static final String SECRET_KEY = "G773qFWSSltwsgWEaUR5rV4EcXKevg9Y";


    /**
     * @author:  wx
     * @Title: idcard
     * @Description: 身份证信息识别
     * @Param: [client]
     * @Return: void
     * @Date: 2018/10/16
     * @Version: v1.0
     **/
    public static void idcard(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "false");
        options.put("detect_risk", "false");

        String idCardSide = "front";

        // 参数为本地图片路径
        String image = "d://test.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res);

//        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.idcard(file, idCardSide, options);
//        System.out.println(res.toString(2));
    }

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        idcard( client );
//        webImage(client);
    }
}
