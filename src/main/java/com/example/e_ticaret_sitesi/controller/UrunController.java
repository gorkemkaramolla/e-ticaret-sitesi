package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/urunler")
public class UrunController {
    private final UrunService urunServisi;

    public UrunController(UrunService urunService)
    {
        this.urunServisi=urunService;
    }

    // ✅ JSON: Tüm ürünleri döner
    @GetMapping
    @ResponseBody
    public List<Urun> urunleriListele() {
        return urunServisi.tumUrunleriGetir();
    }

    // ✅ JSON: Ad ile arama
    @GetMapping("/ara")
    @ResponseBody
    public List<Urun> urunAra(@RequestParam String ad) {
        return urunServisi.adaGoreAra(ad);
    }

    // ✅ JSON: Kategoriye göre filtreleme
    @GetMapping("/kategori/{kategoriId}")
    @ResponseBody
    public List<Urun> kategoriyeGoreFiltrele(@PathVariable Long kategoriId) {
        return urunServisi.kategoriyeGoreFiltrele(kategoriId);
    }

    // ✅ JSON: Ada ve kategoriye göre filtreleme
    @GetMapping("/filtrele")
    @ResponseBody
    public List<Urun> filtreliArama(@RequestParam String ad, @RequestParam Long kategoriId) {
        return urunServisi.adaVeKategoriyeGoreAra(ad, kategoriId);
    }

    // ✅ HTML: Arama destekli ürün sayfası (Thymeleaf için)
   // @GetMapping("/liste")
//    public String urunSayfasi(@RequestParam(required = false) String ad, Model model) {
//        List<Urun> urunler = (ad != null && !ad.isEmpty())
//                ? urunServisi.adaGoreAra(ad)
//                : urunServisi.tumUrunleriGetir();
//        model.addAttribute("urunler", urunler);
//        return "urunler";
//    }
    @GetMapping("/liste")
    public String urunSayfasi(@RequestParam(required = false) String ad, Model model) {
        List<Urun> urunler = (ad != null && !ad.isEmpty())
                ? urunServisi.adaGoreAra(ad)
                : urunServisi.tumUrunleriGetir();
        model.addAttribute("urunler", urunler);
        return "urunler"; // templates/urunler.html
    }

}
