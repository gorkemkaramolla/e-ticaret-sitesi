package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.service.UrunService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnaSayfaController {

    private final UrunService urunServisi;

    public AnaSayfaController(UrunService urunService)
    {
        this.urunServisi=urunService;
    }

    @GetMapping("/")
    public String urunSayfasi(Model model) {
        List<Urun> urunler = urunServisi.tumUrunleriGetir();
        System.out.println(urunler);  // For debugging
        model.addAttribute("urunler", urunler);
        return "home";
    }

}
