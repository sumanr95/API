package com.lib.api;


import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    private ContentType encodeContentTypeAsText;
    private String body;
    private String contentType;
    private String baseUrl;
    private Map<String, String> cookies;
    private Map<String, String> headers;


    public ApiRequest setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public ApiRequest setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }


    public ApiRequest setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public ApiRequest addHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public ApiRequest addHeader(String key, String value) {
        if (this.headers == null) {
            this.headers = new HashMap<String, String>();
        }
        this.headers.put(key, value);
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }


    public String getBody() {
        return body;
    }

    public ApiRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public ContentType getEncodeContentTypeAsText() {
        return encodeContentTypeAsText;
    }

    public ApiRequest setEncodeContentTypeAsText(ContentType encodeContentTypeAsText) {
        this.encodeContentTypeAsText = encodeContentTypeAsText;
        return this;
    }

    public ApiRequest setBody(String body, ContentType contentType) {
        this.body = body;
        this.encodeContentTypeAsText = contentType;
        return this;
    }
}
