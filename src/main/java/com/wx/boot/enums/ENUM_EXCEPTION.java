package com.wx.boot.enums;


import lombok.Getter;

/**
 * @Description: 异常枚举
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/8
 * @Auther: wangxiang
 */
@Getter
public enum ENUM_EXCEPTION {
    E10000("1000000", "登录成功"),
    E10001("1000001", "密码错误"),
    E10002("1000002", "登录失败，该用户已被冻结"),
    E10003("1000003", "该用户不存在"),
    E10004("1000004", "系统出现异常，请联系管理员");

    public final String msg;
    public final String code;

    ENUM_EXCEPTION(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}
