package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;

@Entity
public class Favori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Hangi kullanıcı bu favoriyi ekledi
    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    // Hangi ürün favoriye eklendi
    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urun urun;

    // Getter ve Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }
}
