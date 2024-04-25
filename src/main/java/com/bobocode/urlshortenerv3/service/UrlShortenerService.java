package com.bobocode.urlshortenerv3.service;

public interface UrlShortenerService {

    String shortenUrl(String url);

    String getOriginalUrl(String shortenUrl);

}
