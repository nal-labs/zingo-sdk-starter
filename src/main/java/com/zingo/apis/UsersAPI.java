package com.zingo.apis;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zingo.param.CreateProxyParam;
import com.zingo.request.CreateProxyRequest;
import com.zingo.response.CreateProxyResp;
import com.zingo.response.Rsp;
import com.zingo.utils.ApacheHttpClientUtil;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;

/**
 * @author manta
 * @since 2024/11/29
 */
public class UsersAPI {
    static Gson gson = new Gson();
    private final String baseUrl;

    public UsersAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Rsp<CreateProxyResp> createAaProxy(CreateProxyRequest request,String tmaId,String hash) throws Exception {
        CreateProxyParam param = new CreateProxyParam(request);
        param.setTmaId(tmaId);
        param.setHash(hash);
        String resStr = ApacheHttpClientUtil.post(baseUrl+"user/telegram/createProxy", new StringEntity(gson.toJson(param), ContentType.APPLICATION_JSON));
        return gson.fromJson(resStr, new TypeToken<Rsp<CreateProxyResp>>(){}.getType());
    }
}

