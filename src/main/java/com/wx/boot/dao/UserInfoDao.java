package com.wx.boot.dao;

import com.wx.boot.bean.UserInfo;
import com.wx.boot.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 用户信息dao
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/17
 * @Auther: wangxiang
 */
@Mapper
public interface UserInfoDao extends MyMapper<UserInfo> {
}
