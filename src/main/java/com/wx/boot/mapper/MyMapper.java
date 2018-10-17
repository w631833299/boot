package com.wx.boot.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: mybatis通用接口实现类
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/17
 * @Auther: wangxiang
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
