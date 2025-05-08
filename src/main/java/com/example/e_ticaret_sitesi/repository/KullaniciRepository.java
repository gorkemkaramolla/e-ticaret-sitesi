package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    Optional<Kullanici> findByEposta(String eposta);
}
