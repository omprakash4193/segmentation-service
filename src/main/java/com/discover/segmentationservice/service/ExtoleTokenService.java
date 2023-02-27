package com.discover.segmentationservice.service;

import com.discover.segmentationservice.models.request.TokenDetailsRequest;
import com.discover.segmentationservice.models.response.TokenDetailsResponse;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public interface ExtoleTokenService {
    TokenDetailsResponse createToken(Map<String, Object> headers, TokenDetailsRequest tokenDetailsRequest);

    TokenDetailsResponse getToken(Map<String, Object> headers, String accessToken);

    void deleteToken(Map<String, Object> headers, String accessToken);
}
