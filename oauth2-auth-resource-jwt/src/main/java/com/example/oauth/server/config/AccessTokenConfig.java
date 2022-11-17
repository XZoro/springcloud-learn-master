package com.example.oauth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author xzq
 * @date 2022年11月05日 15:07
 */
@Configuration
public class AccessTokenConfig {

    /**
     * JWT的秘钥
     */
    private final static String SIGN_KEY = "zoro";

    /**
     * 令牌的存储策略
     */
    @Bean
    public TokenStore tokenStore(){
        //使用JwtTokenStore生成JWT令牌
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //设置秘钥
        converter.setSigningKey(SIGN_KEY);
        return converter;
    }
}
