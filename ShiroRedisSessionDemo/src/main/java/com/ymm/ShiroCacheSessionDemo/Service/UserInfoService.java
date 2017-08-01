package com.ymm.ShiroCacheSessionDemo.Service;

import com.ymm.ShiroCacheSessionDemo.Domain.UserInfo;

/**
 * Created by James on 7/31/2017.
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
