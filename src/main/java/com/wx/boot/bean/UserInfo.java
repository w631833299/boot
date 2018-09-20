package com.wx.boot.bean;

import java.io.Serializable;

/**
 * 用户信息
 */
public class UserInfo implements Serializable {

    /**主键id*/
    private Integer uid;

    /**账号*/
    private String username;

    /**名称（昵称或者真实姓名，不同系统不同定义）*/
    private String name;

    /**密码*/
    private String password;

    /**加密密码的盐*/
    private String salt;

    /**用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.*/
    private byte state;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    /**
     * 组装加密盐
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}
