package com.bobocode.urlshortenerv3.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private static final int RANDOM_STRING_LENGTH = 10;

    private final ConcurrentMap<String, String> shortenUrlToOriginalUrl = new ConcurrentHashMap<>();

    @Override
    public String shortenUrl(String url) {
        var uniqueUrl = StringUtils.randomAlphanumeric(RANDOM_STRING_LENGTH);
        shortenUrlToOriginalUrl.put(uniqueUrl, url);
        return uniqueUrl;
    }

    @Override
    public String getOriginalUrl(String shortenUrl){
        return shortenUrlToOriginalUrl.get(shortenUrl);
    }

}
