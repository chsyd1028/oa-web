package com.zmh.oaweb.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


 /**
 * shiro的认证最终是交给了Realm进行执行
 * 所以我们需要自己重新实现一个Realm，此Realm继承AuthorizingRealm
 * Created by sun on 2017-4-2.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Log logger = LogFactory.getLog(AuthorizingRealm.class);

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------进行登陆认证:" + authenticationToken);

        //1.把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        //2.从UsernamePasswordToken中来获取username
        String username = upToken.getUsername();

        //3.调用数据库的方法， 从数据库中查询username对应的用户记录
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------从数据库中获取username:" + username + " 所对应的用户信息");

        //4.若用户不存在， 则可抛出UnknownAccountException异常
        if ("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }

        //5.根据用户信息的情况，决定是否需要抛出其他的AuthenticationException异常
        if ("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //6.根据用户的情况， 来构建AuthenticationInfo对象并返回， 通常使用的实现类为：SimpleAuthenticationInfo
        //以下信息是从数据库中获取的
        //1.principal:认证的实体信息，可以是username，也可以是数表对应的实体类对象
        Object principal = username;
        //2.creadentials： 密码
        Object credentials = "123456";
        //3. realName: 当前对象的name，调用弗雷的getName()方法即可
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);


        //UsernamePasswordToken用于存放提交的登录信息
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        logger.info("登录认证!");
//        logger.info("验证当前Subject时获取到token为：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
//        User user = permissionService.findByUserEmail(token.getUsername());
//        if (user != null){
//            logger.info("用户: " + user.getEmail());
//            if(user.getStatus() == 0){
//                throw new DisabledAccountException();
//            }
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(user.getEmail(), user.getPswd(), getName());
//        }
        return info;
    }

    /**
     * 权限认证（为当前登录的Subject授予角色和权限）
     *
     * 该方法的调用时机为需授权资源被访问时，并且每次访问需授权资源都会执行该方法中的逻辑，这表明本例中并未启用AuthorizationCache，
     * 如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），
     * 超过这个时间间隔再刷新页面，该方法会被执行
     *
     * doGetAuthorizationInfo()是权限控制，
     * 当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
