package com.zingo;

import com.zingo.apis.UsersAPI;
import com.zingo.request.CreateProxyRequest;
import com.zingo.response.CreateProxyResp;
import com.zingo.response.Rsp;
import com.zingo.utils.HmacSHA256Util;
import org.springframework.util.StringUtils;

/**
 * @author manta
 * @since 2024/11/29
 */
public class ZingoSDK {
    private final String tmaId;
    private final String secretKey;


    private UsersAPI usersAPI;

    public ZingoSDK(String baseUrl, String tmaId, String secretKey) {
        this.tmaId = tmaId;
        this.secretKey = secretKey;
        if (!baseUrl.endsWith("/")){
            baseUrl = baseUrl+"/";
        }
        usersAPI = new UsersAPI(baseUrl);
    }

    public Rsp<CreateProxyResp> createAaProxy(CreateProxyRequest request) throws Exception{
        String hash = calcHash(request.getTgId());
        return usersAPI.createAaProxy(request,tmaId,hash);
    }

    private String calcHash(Long tgId){
        if (!StringUtils.hasLength(tmaId) || !StringUtils.hasLength(secretKey)){
            throw new RuntimeException("zingo sdk configuration loaded failed!");
        }
        return HmacSHA256Util.hmacSHA256(tmaId + tgId, secretKey);
    }
}
