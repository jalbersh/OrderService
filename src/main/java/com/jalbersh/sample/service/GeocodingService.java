package com.jalbersh.sample.service;

import com.jalbersh.sample.model.GeoCodingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {
    RestTemplate restTemplate;

    @Value( "${mapquest.consumer.key}" )
    private String consumerKey;

    @Value( "${mapquest.geocoding.url}" )
    private String geocodingUrl;

    private GeoCodingResponse getGeocoding(String address) {
        ResponseEntity<GeoCodingResponse> responseEntity = null;
        restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.getForEntity(geocodingUrl, GeoCodingResponse.class);
        } catch (Exception e) {
            System.out.println("Exception happened: "+e.getMessage());
        }
        if (responseEntity.getStatusCode() == HttpStatus.OK) return responseEntity.getBody();
        return null;
    }
}
