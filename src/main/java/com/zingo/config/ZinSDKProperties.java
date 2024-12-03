package com.zingo.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @author manta
 * @since 2024/11/29
 */
@ConfigurationProperties(prefix = "zingosdk")
public class ZinSDKProperties {
    private String baseUrl = "https://zingo-api.nal.network";
    private String tmaId;
    private String secretKey;

    // Getters and Setters
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getTmaId() {
        return tmaId;
    }

    public void setTmaId(String tmaId) {
        this.tmaId = tmaId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

