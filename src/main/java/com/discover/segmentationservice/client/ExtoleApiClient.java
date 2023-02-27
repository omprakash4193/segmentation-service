package com.discover.segmentationservice.client;

import com.discover.segmentationservice.models.request.TokenDetailsRequest;
import com.discover.segmentationservice.models.response.TokenDetailsResponse;
import feign.HeaderMap;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@Headers({"Accept: application/json", "Content Type: application/json"})
public interface ExtoleApiClient {

    @RequestLine("POST /token")
    TokenDetailsResponse createToken(@HeaderMap Map<String, Object> headers, TokenDetailsRequest tokenDetailsRequest);

    @RequestLine("GET /token/{token_id}")
    TokenDetailsResponse getToken(@HeaderMap Map<String, Object> headers, @PathVariable("token_id") String token_id);

    @RequestLine("DELETE /token/{token_id}")
    void deleteToken(@HeaderMap Map<String, Object> headers, @PathVariable("token_id") String token_id);
}
