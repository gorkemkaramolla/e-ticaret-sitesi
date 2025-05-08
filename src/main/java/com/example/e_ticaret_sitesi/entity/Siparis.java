package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    @ManyToMany
    @JoinTable(
            name = "siparis_urun",
            joinColumns = @JoinColumn(name = "siparis_id"),
            inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private List<Urun> urunler;

    private LocalDateTime tarih;

    // ✅ Ödeme durumu
    private boolean odendi = false;


}
