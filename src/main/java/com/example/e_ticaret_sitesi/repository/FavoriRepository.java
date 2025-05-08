package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Favori;
import com.example.e_ticaret_sitesi.entity.Kullanici;
import com.example.e_ticaret_sitesi.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriRepository extends JpaRepository<Favori, Long> {

    // Belirli bir kullanıcının tüm favorileri
    List<Favori> findByKullanici(Kullanici kullanici);

    // Aynı ürün zaten favoride mi?
    Optional<Favori> findByKullaniciAndUrun(Kullanici kullanici, Urun urun);
}
