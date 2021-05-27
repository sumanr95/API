package com.lib.api;

import com.lib.enums.HttpMethod;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    public static ApiResponse executeBaseRequest(HttpMethod httpMethod, ApiRequest apiRequest) {
        RequestSpecification requestSpecification = baseRequest(httpMethod, apiRequest);
        String baseUrl = apiRequest.getBaseUrl();
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = RestAssured.given().spec(requestSpecification).get(baseUrl);
                break;
            case POST:
                response = RestAssured.given().spec(requestSpecification).post(baseUrl);
                break;
            case HEAD:
                response = RestAssured.given().spec(requestSpecification).head(baseUrl);
                break;
            case DELETE:
                response = RestAssured.given().spec(requestSpecification).delete(baseUrl);
                break;
            case PUT:
                response = RestAssured.given().spec(requestSpecification).put(baseUrl);
                break;
        }
        return processRestAssuredResponse(response);
    }

    private static ApiResponse processRestAssuredResponse(Response response) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(response.getStatusCode())
                .setStatusLine(response.getStatusLine());

        if (response.getHeaders() != null && response.getHeaders().size() > 0) {
            Map<String, String> responseHeaders = new HashMap<String, String>();
            for (Header header: response.getHeaders()) {
                responseHeaders.put(header.getName(), header.getValue());
            }
            apiResponse.setHeaders(responseHeaders);
        }

        if (response.asByteArray() != null) {
            apiResponse.setByteArray(response.asByteArray());
        }

        apiResponse.setResponseBody(response.body().asString());
        return apiResponse;
    }

    private static RequestSpecification baseRequest(HttpMethod httpMethod, ApiRequest apiRequest) {
        RequestSpecification requestSpecification = null;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        EncoderConfig encoderConfig = null;

        if (apiRequest.getEncodeContentTypeAsText() != null) {
            encoderConfig = EncoderConfig.encoderConfig()
                    .encodeContentTypeAs(apiRequest.getContentType(), apiRequest.getEncodeContentTypeAsText())
                    .appendDefaultContentCharsetToContentTypeIfUndefined(false);

            RestAssuredConfig restAssuredConfig = RestAssured.config().encoderConfig(encoderConfig);
            requestSpecBuilder.setConfig(restAssuredConfig);
        }

        if (apiRequest.getContentType() != null) {
            requestSpecBuilder.setContentType(apiRequest.getContentType());
        }
        if (apiRequest.getHeaders() != null) {
            requestSpecBuilder.addHeaders(apiRequest.getHeaders());
        }
        
        if (apiRequest.getBody() != null) {
            requestSpecBuilder.setBody(apiRequest.getBody());
        }
        if (apiRequest.getCookies() != null) {
            requestSpecBuilder.addCookies(apiRequest.getCookies());
        }

        requestSpecification = requestSpecBuilder.build().log().all();
        return requestSpecification;
    }

}
