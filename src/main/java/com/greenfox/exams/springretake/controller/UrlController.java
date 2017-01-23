package com.greenfox.exams.springretake.controller;

import com.greenfox.exams.springretake.domain.Url;
import com.greenfox.exams.springretake.repository.UrlRepository;
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
    UrlRepository urlRepository;

    @Autowired
    public UrlController(UrlService urlService, UrlRepository urlRepository) {
        this.urlService = urlService;
        this.urlRepository= urlRepository;
    }

    @GetMapping("/shortit")
    public String showmain(Model model, Url url) {
        model.addAttribute("Url", new Url());
        return "mainform";
    }

    @PostMapping("/shortit")
    public String urlSubmit(@ModelAttribute Url url, Model model) {
        if(urlService.checkUrl(url)) {
            url.setGeneratedKey(urlService.generateKey());
            urlService.savetoRepo(url);
            model.addAttribute("Url", urlRepository.findByGeneratedKey(url.getGeneratedKey()));
            return "showpage";
        }else
            url.setUrlinput("http://" + url.getUrlinput());
        url.setGeneratedKey(urlService.generateKey());
        urlService.savetoRepo(url);
        model.addAttribute("Url", urlRepository.findByGeneratedKey(url.getGeneratedKey()));
        return "showpage";
    }

    @GetMapping("{urlinput}")
    public String redirectTo(Model model, @PathVariable String urlinput){
        return "redirect:" + urlRepository.findByUrlinput(urlinput).getUrlinput();
    }

    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String error_404(){
        return "mainform";
    }
}
