package com.discover.segmentationservice.service.Impl;

import com.discover.segmentationservice.client.ExtoleApiClient;
import com.discover.segmentationservice.models.request.TokenDetailsRequest;
import com.discover.segmentationservice.models.response.TokenDetailsResponse;
import com.discover.segmentationservice.service.ExtoleTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Slf4j
@Component
public class ExtoleTokenServiceImpl implements ExtoleTokenService {

    @Autowired
    private ExtoleApiClient extoleApiClient;

    @Override
    public TokenDetailsResponse createToken(Map<String, Object> headers, TokenDetailsRequest tokenDetailsRequest) {
        log.info("ExtoleTokenServiceImpl -> createToken {}", tokenDetailsRequest);
        return extoleApiClient.createToken(headers, tokenDetailsRequest);
    }

    @Override
    public TokenDetailsResponse getToken(Map<String, Object> headers, String accessToken) {
        log.info("ExtoleTokenServiceImpl -> getToken {}", accessToken);
        return extoleApiClient.getToken(headers, accessToken);
    }

    @Override
    public void deleteToken(Map<String, Object> headers, String accessToken) {
        log.info("ExtoleTokenServiceImpl -> deleteToken {}", accessToken);
        extoleApiClient.deleteToken(headers, accessToken);
    }
}
