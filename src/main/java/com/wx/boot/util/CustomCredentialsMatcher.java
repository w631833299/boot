package com.wx.boot.util;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

/**
 * 自定义密码比较方法
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    /**
     * 字定义加密方法
     * @param authcToken token
     * @param info 数据库查询的数据
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
        Object accountCredentials = getCredentials(info);
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
        return equals(tokenCredentials, accountCredentials);
    }


    /**
     * 明文加密加密方法
     * @param data 明文
     * @return String 加密后的字符才
     */
    public static String encrypt(String data) {
        String sha384Hex = new Sha384Hash(data).toBase64();//这里可以选择自己的密码验证方式 比如 md5或者sha256等
        return sha384Hex;
    }
}
