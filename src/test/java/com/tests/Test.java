package com.tests;

import com.lib.api.ApiClient;
import com.lib.api.ApiRequest;
import com.lib.api.ApiResponse;
import com.lib.enums.HttpMethod;

public class Test {

    @org.testng.annotations.Test
    public void lauchpads() {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setBaseUrl("https://stage.spacexdata.com/v4/launchpads/query");
        ApiResponse apiResponse = ApiClient.executeBaseRequest(HttpMethod.GET, apiRequest);
        System.out.println(apiResponse.getStatusCode());
    }

    @org.testng.annotations.Test
    public void launches() {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setBaseUrl("https://stage.spacexdata.com/v4/launches/query");
        ApiResponse apiResponse = ApiClient.executeBaseRequest(HttpMethod.GET, apiRequest);
        System.out.println(apiResponse.getStatusCode());
    }

    @org.testng.annotations.Test
    public void updateLaunches() {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setBaseUrl("https://stage.spacexdata.com/v4/launches/query");
        ApiResponse apiResponse = ApiClient.executeBaseRequest(HttpMethod.POST, apiRequest);
        System.out.println(apiResponse.getStatusCode());
    }
}
