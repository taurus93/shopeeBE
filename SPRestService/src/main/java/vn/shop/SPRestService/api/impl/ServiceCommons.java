package vn.shop.SPRestService.api.impl;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;


/**
 * Created by lttung on 1/2/2019.
 */
public class ServiceCommons {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceCommons.class);

    protected String postDataToService(String url, Object data){
        RestTemplate restClient = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        restClient.getMessageConverters().add(0, new StringHttpMessageConverter());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Content-Type","application/json; charset=utf-8");
        HttpEntity<String> request = new HttpEntity<>((data == null || data.toString().isEmpty()) ? null: data.toString(), httpHeaders);

        LOGGER.info("Send POST request to URL: {} and body request {}",  url, request.getBody());
        String retReq = restClient.postForObject(url, request, String.class);

        if(retReq != null && !retReq.isEmpty()){
            LOGGER.info("End postDataToService: success");
            return retReq;
        }
        LOGGER.info("End postDataToService: null");
        return null;
    }

    protected String getDataToService(String url) {
        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("Send GET request to URL: {}", url);
        String retReq = restTemplate.getForObject(url, String.class);

        if(retReq != null && !retReq.isEmpty()) {
            LOGGER.info("End get Data to Service: success");
            return retReq;
        }
        LOGGER.info("End get Data to Service: null");
        return null;
    }
}
