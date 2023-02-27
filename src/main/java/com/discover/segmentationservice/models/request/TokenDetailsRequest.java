package com.discover.segmentationservice.models.request;

import lombok.Data;

@Data
public class TokenDetailsRequest {
    private String email;
    private String jwt;
}
