package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.*;
import com.example.e_ticaret_sitesi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    @Autowired
    private SepetRepository sepetRepository;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    // ✅ Sipariş oluştur
    public Siparis siparisOlustur(Long kullaniciId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Sepet sepet = sepetRepository.findByKullanici(kullanici)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı"));

        List<Urun> urunler = sepet.getUrunler();
        if (urunler == null || urunler.isEmpty()) {
            throw new RuntimeException("Sepet boş, sipariş oluşturulamaz.");
        }

        Siparis siparis = new Siparis();
        siparis.setKullanici(kullanici);
        siparis.setUrunler(new ArrayList<>(urunler));
        siparis.setTarih(LocalDateTime.now());

        // Sepeti boşalt
        sepet.setUrunler(new ArrayList<>());
        sepetRepository.save(sepet);

        return siparisRepository.save(siparis);
    }

    // ✅ Tüm siparişleri getir
    public List<Siparis> siparisleriListele(Long kullaniciId) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        return siparisRepository.findByKullanici(kullanici);
    }

    // ✅ Sipariş sil
    public void siparisiSil(Long siparisId) {
        if (!siparisRepository.existsById(siparisId)) {
            throw new RuntimeException("Silinecek sipariş bulunamadı.");
        }
        siparisRepository.deleteById(siparisId);
    }

    // ✅ Demo ödeme işlemi (simülasyon)
    public Siparis odemeYap(Long siparisId) {
        Siparis siparis = siparisRepository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı"));

        if (siparis.isOdendi()) {
            throw new RuntimeException("Bu sipariş zaten ödenmiş.");
        }

        siparis.setOdendi(true); // ödeme başarılı
        return siparisRepository.save(siparis);
    }
}
