package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {

    // 🔍 Ürün adına göre arama (örnek: "mac" → "MacBook")
    List<Urun> findByAdContainingIgnoreCase(String ad);

    // 🔍 Belirli bir kategoriye göre ürünleri getir
    List<Urun> findByKategori(Kategori kategori);

    // 🔍 Hem ada göre, hem kategoriye göre arama (opsiyonel)
    List<Urun> findByAdContainingIgnoreCaseAndKategori(String ad, Kategori kategori);
}
