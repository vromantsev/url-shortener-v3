package com.bobocode.urlshortenerv3.controller;

import com.bobocode.urlshortenerv3.dto.CreateShortUrlRequest;
import com.bobocode.urlshortenerv3.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlShortenerService urlShortenerService;

    @PostMapping("/short-url")
    public String generateShortUrl(@ModelAttribute final CreateShortUrlRequest createShortUrlRequest,
                                   final HttpServletRequest request,
                                   final Model model) {
        var shortUrl = this.urlShortenerService.shortenUrl(createShortUrlRequest.initialUrl());
        model.addAttribute("shortUrl", request.getRequestURL().toString() + "/" + shortUrl);
        return "index";
    }
}
