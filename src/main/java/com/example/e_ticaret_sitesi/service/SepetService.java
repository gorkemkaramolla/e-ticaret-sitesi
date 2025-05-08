package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.*;
import com.example.e_ticaret_sitesi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SepetService {

    @Autowired
    private SepetRepository sepetRepository;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private UrunRepository urunRepository;

    // ✅ 1. Sepete ürün ekle
    public Sepet sepeteUrunEkle(Long kullaniciId, Long urunId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Urun urun = urunRepository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        // Kullanıcının sepeti varsa getir, yoksa yeni oluştur
        Sepet sepet = sepetRepository.findByKullanici(kullanici)
                .orElse(new Sepet());

        sepet.setKullanici(kullanici);

        // Mevcut ürün listesine yeni ürünü ekle
        List<Urun> urunler = sepet.getUrunler() == null ? new ArrayList<>() : sepet.getUrunler();
        urunler.add(urun);
        sepet.setUrunler(urunler);

        return sepetRepository.save(sepet);
    }

    // ✅ 2. Kullanıcının sepetini getir
    public List<Urun> sepetiGoruntule(Long kullaniciId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        return sepetRepository.findByKullanici(kullanici)
                .map(Sepet::getUrunler)
                .orElse(Collections.emptyList());
    }

    // ✅ 3. Sepetten ürün sil
    public Sepet sepettenUrunSil(Long kullaniciId, Long urunId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Urun urun = urunRepository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        Sepet sepet = sepetRepository.findByKullanici(kullanici)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı"));

        List<Urun> urunler = sepet.getUrunler();
        urunler.remove(urun); // Ürün listeden çıkarılır
        sepet.setUrunler(urunler);

        return sepetRepository.save(sepet);
    }
}
