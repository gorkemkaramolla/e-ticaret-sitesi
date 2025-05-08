package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Kategori;
import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kategoriler")
public class KategoriController {


    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @GetMapping
    public List<Kategori> tumKategoriler() {
        return kategoriService.getTumKategoriler();
    }

    @PostMapping
    public Kategori yeniKategori(@RequestBody Kategori kategori) {
        return kategoriService.yeniKategoriEkle(kategori);
    }

    @DeleteMapping("/{id}")
    public void kategoriSil(@PathVariable Long id) {
        kategoriService.kategoriSil(id);
    }

    @GetMapping("/liste")
    public String kategoriSayfasi(Model model) {
        List<Kategori> kategoriler = kategoriService.getTumKategoriler();
        model.addAttribute("kategoriler", kategoriler);
        return "kategoriler";
    }



}
