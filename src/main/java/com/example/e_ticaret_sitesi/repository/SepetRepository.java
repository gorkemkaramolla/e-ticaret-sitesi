package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Sepet;
import com.example.e_ticaret_sitesi.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SepetRepository extends JpaRepository<Sepet, Long> {
    Optional<Sepet> findByKullanici(Kullanici kullanici);
}
