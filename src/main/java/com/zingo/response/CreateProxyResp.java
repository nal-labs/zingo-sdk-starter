package com.zingo.response;

/**
 * @author manta
 * @since 2024/11/29
 */
public class CreateProxyResp {

    private Long tgId;
    private String proxy;

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    @Override
    public String toString() {
        return "CreateProxyResp{" +
                "tgId=" + tgId +
                ", proxy='" + proxy + '\'' +
                '}';
    }
}
