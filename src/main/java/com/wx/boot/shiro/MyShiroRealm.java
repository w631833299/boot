package com.wx.boot.shiro;

import com.wx.boot.bean.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;
import java.util.Random;

public class MyShiroRealm extends AuthorizingRealm {

    /**用户业务处理类*/
//    @Resource
//    private UserInfoService userInfoService;

    /**
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行，
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo进行角色的添加和权限的添加。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
////        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
//        for (SysRole role : userInfo.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        return null;
    }

    /**
     * doGetAuthenticationInfo的重写
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

        //根据账号查询数据库，返回账号对象
//        UserInfo userInfo = userInfoService.findByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wx");
        userInfo.setPassword("CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU");//密码明文是123456
        userInfo.setSalt("wxKYXuTPST5SG0jMQzVPsg==");//加密密码的盐值
        userInfo.setUid(new Random().nextInt());//随机分配一个id
        if (userInfo == null) {
            return null;
        }
        if (userInfo.getState() == 1) { //账户冻结
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getPassword()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 重写shiro的密码验证，让shiro用我自己的验证
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        setCredentialsMatcher(new CustomCredentialsMatcher());
    }
}
