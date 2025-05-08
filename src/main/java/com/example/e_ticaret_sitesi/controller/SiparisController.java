package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Siparis;
import com.example.e_ticaret_sitesi.service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siparisler")
public class SiparisController {

    @Autowired
    private SiparisService siparisServisi;

    // ✅ Sipariş oluştur
    @PostMapping("/olustur/{kullaniciId}")
    public Siparis siparisOlustur(@PathVariable Long kullaniciId) {
        return siparisServisi.siparisOlustur(kullaniciId);
    }

    // ✅ Siparişleri listele
    @GetMapping("/{kullaniciId}")
    public List<Siparis> siparisleriListele(@PathVariable Long kullaniciId) {
        return siparisServisi.siparisleriListele(kullaniciId);
    }

    // ✅ Siparişi sil (iptal et)
    @DeleteMapping("/sil/{siparisId}")
    public void siparisiSil(@PathVariable Long siparisId) {
        siparisServisi.siparisiSil(siparisId);
    }

    // ✅ Demo ödeme endpoint’i
    @PostMapping("/odeme/{siparisId}")
    public Siparis odemeYap(@PathVariable Long siparisId) {
        return siparisServisi.odemeYap(siparisId);
    }
}
