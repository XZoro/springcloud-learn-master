package com.example.oauth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 令牌相关的配置类
 *
 * @author xzq
 * @date 2022年11月03日 15:32
 */
@Configuration
public class AccessTokenConfig {

    /**
     * 令牌的存储策略
     */
    @Bean
    TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
