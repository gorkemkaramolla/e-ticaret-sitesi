package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.Kategori;
import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.repository.KategoriRepository;
import com.example.e_ticaret_sitesi.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrunService {

    private final UrunRepository urunRepository;

    private final KategoriRepository kategoriRepository;

    public UrunService(UrunRepository urunRepository, KategoriRepository kategoriRepository) {
        this.urunRepository = urunRepository;
        this.kategoriRepository = kategoriRepository;
    }
    public  Optional<Urun> findById(Long id)
    {
        return  urunRepository.findById(id);
    }
    public List<Urun> tumUrunleriGetir() {
        return urunRepository.findAll();
    }

    public List<Urun> adaGoreAra(String ad) {
        return urunRepository.findByAdContainingIgnoreCase(ad);
    }

    public List<Urun> kategoriyeGoreFiltrele(Long kategoriId) {
        Kategori kategori = kategoriRepository.findById(kategoriId)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        return urunRepository.findByKategori(kategori);
    }

    // ✅ Hem ad hem kategoriye göre filtreleme (opsiyonel kullanım)
    public List<Urun> adaVeKategoriyeGoreAra(String ad, Long kategoriId) {
        Kategori kategori = kategoriRepository.findById(kategoriId)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        return urunRepository.findByAdContainingIgnoreCaseAndKategori(ad, kategori);
    }
}
