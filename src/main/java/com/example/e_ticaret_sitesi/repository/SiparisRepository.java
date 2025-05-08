package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Siparis;
import com.example.e_ticaret_sitesi.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiparisRepository extends JpaRepository<Siparis, Long> {

    // Belirli kullanıcının geçmiş siparişleri
    List<Siparis> findByKullanici(Kullanici kullanici);
}
