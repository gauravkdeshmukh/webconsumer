package com.featureflags.webconsumer.dataservice;

import com.featureflags.webconsumer.WebconsumerApplication;
import com.featureflags.webconsumer.model.Flag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FFConsumerService {

    FFConsumerService(){}
    private static final Logger log = LoggerFactory.getLogger(WebconsumerApplication.class);

    @Value("${spring.datasource.server.url}")
    private String dataSourceUrl;

    public ResponseEntity<List<Flag>> getAllFeatureFlags() {
            String reqUrl = dataSourceUrl + "/featureflags";
            RestTemplate getTemplate = new RestTemplate();
            ResponseEntity<List<Flag>> flagResponse = getTemplate.exchange(reqUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flag>>(){});
            return flagResponse;
    }

    public ResponseEntity<List<Flag>> save(Flag flag){
        String postUrl =  dataSourceUrl + "/featureflags";
        RestTemplate postTemplate = new RestTemplate();
        ResponseEntity<List<Flag>> postResponse = postTemplate.exchange(postUrl,
                            HttpMethod.POST, new HttpEntity<>(flag), new ParameterizedTypeReference<List<Flag>>() {
                            });
        return postResponse;
    }
}
