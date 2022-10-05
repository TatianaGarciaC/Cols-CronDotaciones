package com.colsubsidio.dotaciones.scheduled.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.AuthApigeeRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.AuthApigeeResponse;

@FeignClient(name = "apigee-token-client", url = "${apigee.url}", configuration = RestClientConfig.class)
public interface ApigeeRestTokenClient {
    @PostMapping("${apigee.path.auth}")
    AuthApigeeResponse getAuthToken(@RequestBody AuthApigeeRequest authRequest, @RequestHeader(name = "Content-Type") String aplication);
}
