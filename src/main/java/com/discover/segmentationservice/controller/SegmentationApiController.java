package com.discover.segmentationservice.controller;

import com.discover.segmentationservice.models.request.TokenDetailsRequest;
import com.discover.segmentationservice.models.response.TokenDetailsResponse;
import com.discover.segmentationservice.service.ExtoleTokenService;
import com.discover.segmentationservice.utils.HeaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/discover")
public class SegmentationApiController {

    @Autowired
    private ExtoleTokenService extoleTokenService;

    @GetMapping("/health")
    String healthCheck(){
        log.info("Received request check health of the application.");
        return "Up";
    }

    @PostMapping("/token")
    TokenDetailsResponse createToken(HttpServletRequest httpServletRequest, @RequestBody TokenDetailsRequest tokenDetailsRequest){
        log.info("Received request to create token {}", tokenDetailsRequest);
        Map<String, Object> headers = HeaderUtils.createHeader(httpServletRequest);
        return extoleTokenService.createToken(headers, tokenDetailsRequest);
    }

    @GetMapping("/token/{token_id}")
    TokenDetailsResponse getToken(HttpServletRequest httpServletRequest, @PathVariable("token_id") String token_id){
        log.info("Received request to get token {}", token_id);
        Map<String, Object> headers = HeaderUtils.createHeader(httpServletRequest);
        return extoleTokenService.getToken(headers, token_id);
    }


    @DeleteMapping("/token/{access_token}")
    void deleteToken(HttpServletRequest httpServletRequest, @PathVariable("token_id") String token_id){
        log.info("Received request to get token {}", token_id);
        Map<String, Object> headers = HeaderUtils.createHeader(httpServletRequest);
        extoleTokenService.deleteToken(headers, token_id);
    }
}
