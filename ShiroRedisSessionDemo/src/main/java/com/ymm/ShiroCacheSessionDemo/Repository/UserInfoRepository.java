package com.ymm.ShiroCacheSessionDemo.Repository;

import com.ymm.ShiroCacheSessionDemo.Domain.UserInfo;
import org.springframework.data.repository.Repository;

/**
 * Created by James on 7/31/2017.
 */
public interface UserInfoRepository extends Repository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
