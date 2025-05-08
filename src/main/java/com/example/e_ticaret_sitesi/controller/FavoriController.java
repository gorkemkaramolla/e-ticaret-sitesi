package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.dto.FavoriEkleDto;
import com.example.e_ticaret_sitesi.entity.Favori;
import com.example.e_ticaret_sitesi.service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoriler")
public class FavoriController {

    @Autowired
    private FavoriService favoriServisi;

    // ✅ JSON üzerinden favori ekle
    @PostMapping("/ekle")

    public Favori favoriEkle(@RequestBody FavoriEkleDto dto) {
        return favoriServisi.favoriEkle(dto.getKullaniciId(), dto.getUrunId());
    }

    // ✅ Kullanıcının favorilerini listele
    @GetMapping("/{kullaniciId}")
    public List<Favori> favorileriListele(@PathVariable Long kullaniciId) {
        return favoriServisi.favorileriListele(kullaniciId);
    }

    // ✅ Favori sil (favoriId'ye göre)
    @DeleteMapping("/sil/{favoriId}")
    public void favoriSil(@PathVariable Long favoriId) {
        favoriServisi.favoriSil(favoriId);
    }
}
