package com.okta.blog.sqlinjection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuxController {

    @GetMapping("/")
    public String index(@RequestParam(name="name", required=false, defaultValue="Symphonian") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/payloads")
    public String index(Model model) {
        return "payloads";
    }
}