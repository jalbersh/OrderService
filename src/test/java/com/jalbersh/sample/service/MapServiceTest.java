package com.jalbersh.sample.service;

import com.jalbersh.sample.model.OrderRequest;
import com.jalbersh.sample.model.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class MapServiceTest {
    private MapService mapService;

    @Before
    public void setUp() throws Exception {
//        mapService = new MapService();
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
    key=CAhSuKNqSBZ1LyitrqhPsz1VnYoAm1TN&from=15193 W 63rd Ave, Arvada, CO 80403&to=951 Stanley Ct, Erie, CO 80516
     */
    @Test
    public void testGetTimeBetweenAddresses() {
        String address2 = "951 Stanley Ct, Erie, CO 80516";
        String address1 = "15193 W 63rd Ave, Arvada, CO 80403";
        String consumerKey = "CAhSuKNqSBZ1LyitrqhPsz1VnYoAm1TN";
        String routeUrl = "http://www.mapquestapi.com/directions/v2/route";
        String url = routeUrl+"?key="+consumerKey+"&from="+address1+"&to="+address2;
        String time = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Route> responseEntity = restTemplate.getForEntity(url, Route.class);
        if (responseEntity.getStatusCode()== HttpStatus.OK) {
            time = responseEntity.getBody().getFormattedTime();
        }
        else {
            time = "no time";
        }
        assertEquals("00:34:40", time);
    }

    @Test
    public void testGetTime() {
        OrderRequest request = new OrderRequest();
//        String time = mapService.getTime(request);
    }

}
