package com.ymm.ShiroCacheSessionDemo.Configuration;

import com.ymm.ShiroCacheSessionDemo.Domain.SysPermission;
import com.ymm.ShiroCacheSessionDemo.Domain.SysRole;
import com.ymm.ShiroCacheSessionDemo.Domain.UserInfo;
import com.ymm.ShiroCacheSessionDemo.Service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by James on 7/31/2017.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        System.out.println(new Date() + " Permission Config-->MyShiroRealm.doGetAuthorizationInfo()");
        for (SysRole role : userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        String username = (String) authenticationToken.getPrincipal();

        System.out.println("[-->" + authenticationToken.getCredentials());

        UserInfo userInfo = userInfoService.findByUsername(username);

        if (userInfo == null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getCredentialsSalt()), getName());

        return authenticationInfo;
    }
}
