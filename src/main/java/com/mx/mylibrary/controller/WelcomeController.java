package com.mx.mylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping({"/","/home"})
    @ResponseBody
    String home() {
        return "My Library :: Status :: ON";
    }
}
