package com.greenfox.exams.springretake.controller;

import com.greenfox.exams.springretake.domain.Url;
import com.greenfox.exams.springretake.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */
@Controller
public class UrlController {

    UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping(value = "/shortenit")
    public String showForm(Url url) {
        return "shortener";
    }

    @PostMapping(value = "/submit")
    public String submit(@ModelAttribute Url url, @PathVariable String generated) {
        urlService.validate(url);
        url.setGenerated(urlService.shortenUrls());
        urlService.savetoRepo(url);
        return "redirect:/shorten/" + url.getGenerated();
    }

    @RequestMapping("/shorten/{generated}")
    public String showNewUrl(Model model, @PathVariable String generated) {
        model.addAttribute("Url",urlService.findeagain(generated));
        return "showpage";
    }
}
