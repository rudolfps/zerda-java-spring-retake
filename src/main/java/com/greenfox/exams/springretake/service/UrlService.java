package com.greenfox.exams.springretake.service;

import com.greenfox.exams.springretake.domain.Url;
import com.greenfox.exams.springretake.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */

@Service
public class UrlService {

    UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url savetoRepo(Url url) {
        return urlRepository.save(url);
    }

    public boolean checkUrl(Url url) {
        return url.getUrlinput().contains("http") || url.getUrlinput().contains("https");
    }

    public String generateKey() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String generated = sb.toString();
        return generated;
    }
}
