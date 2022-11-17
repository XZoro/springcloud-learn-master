package com.example.oauth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 令牌相关配置
 * @author xzq
 * @date 2022年11月05日 11:48
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

    /**
     * JwtAccessTokenConverter
     * TokenEnhancer的子类，在JWT编码的令牌值和OAuth身份验证信息之间进行转换。
     * TODO：后期可以使用非对称加密
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //设置秘钥
        converter.setSigningKey(SIGN_KEY);
        return converter;
    }

}
