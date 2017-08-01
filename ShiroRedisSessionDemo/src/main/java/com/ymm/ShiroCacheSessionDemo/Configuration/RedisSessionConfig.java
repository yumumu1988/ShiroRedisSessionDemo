package com.ymm.ShiroCacheSessionDemo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by James on 7/31/2017.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
