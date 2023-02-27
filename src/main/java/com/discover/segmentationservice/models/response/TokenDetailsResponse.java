package com.discover.segmentationservice.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDetailsResponse {
    private String access_token;
    private String expires_in;
    private List<String> scopes;
    private List<String> capabilities;
}
