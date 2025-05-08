package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.dto.SepetEkleDto;
import com.example.e_ticaret_sitesi.entity.Sepet;
import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.service.SepetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sepet")
public class SepetController {

    @Autowired
    private SepetService sepetServisi;

    // ✅ 1. JSON üzerinden sepete ürün ekleme
    // Kullanıcı ID ve ürün ID JSON olarak gönderilir
    // POST /sepet/ekle
    @PostMapping("/ekle")
    public Sepet sepeteEkleJson(@RequestBody SepetEkleDto veri) {
        return sepetServisi.sepeteUrunEkle(veri.getKullaniciId(), veri.getUrunId());
    }

    // ✅ 2. Kullanıcının sepetindeki ürünleri listeleme
    // GET /sepet/{kullaniciId}
    @GetMapping("/{kullaniciId}")
    public List<Urun> sepetiListele(@PathVariable Long kullaniciId) {
        return sepetServisi.sepetiGoruntule(kullaniciId);
    }

    // ✅ 3. Sepetten ürün silme
    // DELETE /sepet/{kullaniciId}/sil/{urunId}
    @DeleteMapping("/{kullaniciId}/sil/{urunId}")
    public Sepet sepettenSil(@PathVariable Long kullaniciId, @PathVariable Long urunId) {
        return sepetServisi.sepettenUrunSil(kullaniciId, urunId);
    }
}
