package com.laqr.NewspaperDeliverySystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebsiteHome {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String firstPage(ModelMap model) {
        return "login";
    }
}