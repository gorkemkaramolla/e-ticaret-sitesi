package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table

public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    // ✅ Boş yapıcı (JPA için)
    public Kategori() {}

    // ✅ Parametreli yapıcı (veri yükleme için)
    public Kategori(String ad) {
        this.ad = ad;
    }


}
