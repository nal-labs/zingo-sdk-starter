package com.zingo.utils;


import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author manta
 * @since 2024/11/29
 */
public class ApacheHttpClientUtil {
    static final Logger logger = LoggerFactory.getLogger(ApacheHttpClientUtil.class);

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    static  {
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(Timeout.ofMilliseconds(1000))
                .build();

        PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder
                .create()
                .setDefaultSocketConfig(socketConfig)
                .setMaxConnTotal(1000)
                .setMaxConnPerRoute(200)
                .build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(8000))
                .setResponseTimeout(Timeout.ofMilliseconds(8000))
                .setConnectTimeout(Timeout.ofMilliseconds(8000))
                .build();

        httpClient = HttpClients
                .custom()
                .disableContentCompression()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }


    public static String get(String url) throws IOException, ParseException {
        return get(url,null,null);
    }

    /**
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException, ParseException {
        HttpGet httpGet = new HttpGet(url);

        if (headers != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (params != null && params.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            try {
                URI uri = new URIBuilder(new URI(url)).addParameters(nvps).build();
                httpGet.setUri(uri);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

        }

        return dealResponse(httpGet);
    }


    private static String dealResponse(HttpUriRequestBase requestBase) throws IOException, ParseException {
        String resultContent;
        try (CloseableHttpResponse response = httpClient.execute(requestBase)) {
            int code = response.getCode();
            HttpEntity entity = response.getEntity();
            resultContent = EntityUtils.toString(response.getEntity(),"UTF-8");
            if (code != HttpStatus.SC_OK) {
                throw new HttpResponseException(code,resultContent);
            }
            EntityUtils.consume(entity);
        }
        return resultContent;
    }

    public static String post(String url, HttpEntity httpEntity, Map<String, String> headers) throws IOException, ParseException {
        HttpPost request = new HttpPost(url);

        if (headers != null){
            BasicHeader[] head = mapToHeaders(headers);
            request.setHeaders(head);
        }
        request.setEntity(httpEntity);
        return dealResponse(request);
    }

    public static String post(String url, HttpEntity httpEntity) throws IOException, ParseException {
        return post(url,httpEntity,null);
    }

    public static BasicHeader[] mapToHeaders(Map<String, String> map) {
        BasicHeader[] headers = new BasicHeader[map.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            headers[i++] = new BasicHeader(entry.getKey(), entry.getValue());
        }
        return headers;
    }

}
