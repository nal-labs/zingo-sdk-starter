package com.zingo.param;

import java.io.Serializable;

/**
 * @author manta
 * @since 2024/11/29
 */
public class BaseParam implements Serializable {
    private String hash;
    private String tmaId;
    private Long tgId;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTmaId() {
        return tmaId;
    }

    public void setTmaId(String tmaId) {
        this.tmaId = tmaId;
    }

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    @Override
    public String toString() {
        return "BaseParam{" +
                "hash='" + hash + '\'' +
                ", tmaId='" + tmaId + '\'' +
                ", tgId='" + tgId + '\'' +
                '}';
    }
}
