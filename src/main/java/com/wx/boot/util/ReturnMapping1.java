package com.wx.boot.util;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 多个注解合并成一个，暂时还没实现
 * @Company:重庆壹平方米网络科技有限公司
 * @Date: 2018/10/17
 * @Auther: wangxiang
 */
public @interface ReturnMapping1 {

    @AliasFor(annotation = RequestMapping.class)
    String[] mapping() default {};

    @AliasFor(annotation = RequiresPermissions.class)
    String[] exclude() default {};
}
