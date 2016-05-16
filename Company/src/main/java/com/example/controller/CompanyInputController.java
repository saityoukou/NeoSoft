package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyInputController {

    @RequestMapping("/companyAdd")
    public String greeting(Model model) {
        return "companyAdd";
    }
}
