package com.discover.segmentationservice.utils;

import com.discover.segmentationservice.models.Constants;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class HeaderUtils {

    public static Map<String, Object> createHeader(HttpServletRequest request){
        Map<String, Object> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, request.getHeader(Constants.AUTHORIZATION));
        return headers;
    }
}
