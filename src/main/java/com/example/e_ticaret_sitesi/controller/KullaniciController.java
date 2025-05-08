package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Kullanici;
import com.example.e_ticaret_sitesi.service.KullaniciService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kullanicilar")
public class KullaniciController {

    private final KullaniciService kullaniciService;
    private final PasswordEncoder passwordEncoder;

    public KullaniciController(KullaniciService kullaniciService, PasswordEncoder passwordEncoder) {
        this.kullaniciService = kullaniciService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Kullanici> getAllUsers() {
        return kullaniciService.getTumKullanicilar();
    }



    @PostMapping
    public String kayitUser(@ModelAttribute Kullanici kullanici) {
        String encodedPassword = passwordEncoder.encode(kullanici.getSifre());
        kullanici.setSifre(encodedPassword);

        kullaniciService.yeniKullaniciEkle(kullanici);

        return "redirect:/giris";
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        kullaniciService.kullaniciSil(id);
    }
}
