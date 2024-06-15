package com.webapp.moviesapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "com.webapp.moviesapp")
@Data
public class CustomProperties {

    private String apiUrl;
    private String apiKey;

}