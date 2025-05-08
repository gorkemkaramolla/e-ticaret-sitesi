package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    @ManyToMany
    @JoinTable(
            name = "sepet_urun",
            joinColumns = @JoinColumn(name = "sepet_id"),
            inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private List<Urun> urunler;


}
