package com.greenfox.exams.springretake.service;

import com.greenfox.exams.springretake.domain.Url;
import com.greenfox.exams.springretake.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */

@Component
public class UrlService {
    
    UrlRepository urlRepo;

    @Autowired
    public UrlService(UrlRepository urlRepo) {
        this.urlRepo = urlRepo;
    }
    public Url savetoRepo (Url url){
        return urlRepo.save(url);
    }
    public Url findOne(Url url) {
        return  urlRepo.findOneByUrl(url);
    }
    public String findeagain(String generated){
        return urlRepo.findOneByGenerated(generated);
    }
    public String validate(Url url) {
            if (checkUrl(url)){
                return url.getUrl();
            }else
                return "http://" + url.getUrl();
        }

    public String shortenUrls(){
        String shortened;
        return shortened = "shortenit/" + generateRandomString();
    }
    private boolean checkUrl(Url url) {
        return url.getUrl().contains("http") || url.getUrl().contains("https");
    }
    private String generateRandomString(){
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

