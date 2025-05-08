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

    @ManyToOne(optional = false)
    @JoinColumn(name = "kullanici_id", nullable = false)
    private Kullanici kullanici;

    @OneToMany(mappedBy = "sepet", cascade = CascadeType.PERSIST)
    private List<UrunSepet> urunSepetList;

    @Column(nullable = false)
    private Boolean aktif = true;
}
