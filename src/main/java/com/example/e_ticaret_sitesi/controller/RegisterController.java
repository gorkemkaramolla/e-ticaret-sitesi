package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.dto.KullaniciKayitDto;
import com.example.e_ticaret_sitesi.service.KullaniciService;
import com.example.e_ticaret_sitesi.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final KullaniciService kullaniciService;
    private final SecurityUtils securityUtils;

    public RegisterController(KullaniciService kullaniciService, SecurityUtils securityUtils) {
        this.kullaniciService = kullaniciService;
        this.securityUtils = securityUtils;
    }


    @GetMapping("/kayit")
    public String showRegistrationForm(Model model) {
        model.addAttribute("kullanici", new KullaniciKayitDto());

        if (securityUtils.isUserLoggedIn()) {
            return "redirect:/";
        }
        return "kayit";
    }

    @PostMapping("/kayit")
    public String kayitUser(@ModelAttribute("kullanici") KullaniciKayitDto dto) {
        kullaniciService.kayitOl(dto);
        return "redirect:/giris?kayitSuccess";
    }
}
