package com.lib.api;

import com.lib.utils.Helper;

import java.util.Map;

public class ApiResponse {

    private String responseBody;
    private int statusCode;
    private String statusLine;
    private Map<String, String> headers;
    private byte[] byteArray;

    public byte[] getByteArray() {
        return byteArray;
    }

    public ApiResponse setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
        return this;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public ApiResponse setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ApiResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public ApiResponse setStatusLine(String statusLine) {
        this.statusLine = statusLine;
        return this;
    }

    public Object getHeaders(Class tClass) {
        return Helper.convertJsonToDTO(Helper.convertDTOToJson(this.headers), tClass);
    }

    public ApiResponse setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
}
