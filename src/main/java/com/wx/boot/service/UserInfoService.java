package com.wx.boot.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.boot.bean.UserInfo;
import com.wx.boot.dao.UserInfoDao;
import com.wx.boot.enums.ENUM_EXCEPTION;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Description: TODO 请用一句话说明作用
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/17
 * @Auther: wangxiang
 */
@Service
@Transactional
public class UserInfoService {

    //用是dao
    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * @author:  wx
     * @Title: ajaxLogin
     * @Description: 登录接口
     * @Param: userInfo 用户对象
     * @Return: java.lang.String
     * @Date: 2018/10/17
     * @Version: v1.0
     **/
    public String ajaxLogin(UserInfo userInfo){
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg",ENUM_EXCEPTION.E10000.msg);
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg",ENUM_EXCEPTION.E10001.msg);
        } catch (LockedAccountException e) {
            jsonObject.put("msg",ENUM_EXCEPTION.E10002.msg);
        } catch (AuthenticationException e) {
            jsonObject.put("msg",ENUM_EXCEPTION.E10003.msg);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("msg",ENUM_EXCEPTION.E10004.msg);
        }
        return jsonObject.toString();
    }


    /**
     * @author:  wx
     * @Title:
     * @Description: 新增用户信息
     * @Param: userInfo 用户对象
     * @Return: 
     * @Date: 2018/10/17
     * @Version: v1.0
     **/
    public void insert(UserInfo userInfo) throws Exception{
        userInfoDao.insert(userInfo);
    }

    /**
     * @author:  wx
     * @Title: findByUsername
     * @Description: 根据用户账号查询信息
     * @Param: [userInfo]
     * @Return: void
     * @Date: 2018/10/17
     * @Version: v1.0
     **/
    public UserInfo findByUsername(String username){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername( username );
        return userInfoDao.selectOne(userInfo);
    }
}
