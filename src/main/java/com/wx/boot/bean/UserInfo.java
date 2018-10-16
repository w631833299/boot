package com.wx.boot.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户信息
 */
@Entity
@Getter
@Setter
public class UserInfo implements Serializable {

    /**主键id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", columnDefinition = "bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键'")
    private Integer uid;

    /**账号*/
    @Column(name = "username", columnDefinition = "varchar(50) comment '账号'")
    private String username;

    /**名称（昵称或者真实姓名，不同系统不同定义）*/
    @Column(name = "name", columnDefinition = "varchar(50) comment '名称'")
    private String name;

    /**密码*/
    @Column(name = "password", columnDefinition = "varchar(50) comment '密码'")
    private String password;

    /**加密密码的盐*/
    @Column(name = "salt", columnDefinition = "varchar(50) comment '加密盐'")
    private String salt;

    /**用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.*/
    @Column(name = "state", columnDefinition = "int(1) comment '用户状态'")
    private int state;

    /**
     * 组装加密盐
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}
