package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.*;
import com.example.e_ticaret_sitesi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriService {

    @Autowired
    private FavoriRepository favoriRepository;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private UrunRepository urunRepository;

    // ✅ Favorilere ürün ekle
    public Favori favoriEkle(Long kullaniciId, Long urunId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Urun urun = urunRepository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        // Daha önce eklenmişse tekrar ekleme
        if (favoriRepository.findByKullaniciAndUrun(kullanici, urun).isPresent()) {
            throw new RuntimeException("Bu ürün zaten favorilerde.");
        }

        Favori favori = new Favori();
        favori.setKullanici(kullanici);
        favori.setUrun(urun);

        return favoriRepository.save(favori);
    }

    // ✅ Kullanıcının tüm favorilerini listele
    public List<Favori> favorileriListele(Long kullaniciId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        return favoriRepository.findByKullanici(kullanici);
    }

    // ✅ Favoriden ürün sil
    public void favoriSil(Long favoriId) {
        favoriRepository.deleteById(favoriId);
    }
}
