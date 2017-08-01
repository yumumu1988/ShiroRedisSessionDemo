package com.ymm.ShiroCacheSessionDemo.Service.Impl;

import com.ymm.ShiroCacheSessionDemo.Domain.UserInfo;
import com.ymm.ShiroCacheSessionDemo.Repository.UserInfoRepository;
import com.ymm.ShiroCacheSessionDemo.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by James on 7/31/2017.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Cacheable(value = "userInfo")
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername() from Database");
        return userInfoRepository.findByUsername(username);
    }
}
