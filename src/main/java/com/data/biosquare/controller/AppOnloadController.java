package com.data.biosquare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppOnloadController {

    @RequestMapping ("/isAppOnloaded")
    public String AppOnload() {
        return "Biosquare App Onloaded!";
    }
}
