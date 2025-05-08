package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.Kategori;
import com.example.e_ticaret_sitesi.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService {

    private  final  KategoriRepository kategoriRepository;

    public KategoriService(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public List<Kategori> getTumKategoriler() {
        return kategoriRepository.findAll();
    }

    public Kategori yeniKategoriEkle(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public void kategoriSil(Long id) {
        kategoriRepository.deleteById(id);
    }
}
