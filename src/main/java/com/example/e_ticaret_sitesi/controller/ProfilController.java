package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Kullanici;
import com.example.e_ticaret_sitesi.service.KullaniciService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ProfilController {

    private final KullaniciService kullaniciService;

    public ProfilController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping("/profil")
    public String profilSayfasiGetir(Model model) {
        String eposta = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<Kullanici> kullaniciOpt = kullaniciService.getKullaniciByEposta(eposta);
        if (kullaniciOpt.isPresent()) {
            model.addAttribute("kullanici", kullaniciOpt.get());
        } else {
            // Giriş yapan kullanıcı sistemde bulunamıyorsa (nadiren olur)
            return "redirect:/login?error";
        }

        return "profil";
    }

}
