package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.dto.KullaniciKayitDto;
import com.example.e_ticaret_sitesi.entity.Kullanici;
import com.example.e_ticaret_sitesi.repository.KullaniciRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public KullaniciService(KullaniciRepository kullaniciRepository, BCryptPasswordEncoder passwordEncoder) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Kullanici yeniKullaniciEkle(Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    public Kullanici kayitOl(KullaniciKayitDto dto) {
        Kullanici yeni = new Kullanici();
        yeni.setKullaniciAdi(dto.getKullaniciAdi());
        yeni.setEposta(dto.getEposta());
        yeni.setSifre(passwordEncoder.encode(dto.getSifre()));
        yeni.setRoller(new HashSet<>(Set.of("ROLE_USER")));
        return kullaniciRepository.save(yeni);
    }

    public List<Kullanici> getTumKullanicilar() {
        return kullaniciRepository.findAll();
    }

    public Optional<Kullanici> getKullaniciByEposta(String eposta) {
        return kullaniciRepository.findByEposta(eposta);
    }

    public void kullaniciSil(Long id) {
        kullaniciRepository.deleteById(id);
    }
}
