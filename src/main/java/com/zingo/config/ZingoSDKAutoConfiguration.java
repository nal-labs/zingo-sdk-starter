package com.zingo.config;

import com.zingo.ZingoSDK;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author manta
 * @since 2024/11/29
 */
@Configuration
@EnableConfigurationProperties(ZinSDKProperties.class)
public class ZingoSDKAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ZingoSDK zingoSDK(ZinSDKProperties properties) {
        return new ZingoSDK(properties.getBaseUrl(), properties.getTmaId(), properties.getSecretKey());
    }
}

