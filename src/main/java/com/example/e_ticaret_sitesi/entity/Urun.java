package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private double fiyat;
    private String aciklama;
    private String resimUrl;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;

    public Urun() {}

    public Urun(String ad, String aciklama, double fiyat, String resimUrl, Kategori kategori) {
        this.ad = ad;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.resimUrl = resimUrl;
        this.kategori = kategori;
    }

}
