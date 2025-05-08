package com.example.e_ticaret_sitesi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class anasayfaController {
    @GetMapping("/")
    public String anasayfayaGit() {
        return "redirect:/urunler/liste";
    }
}
