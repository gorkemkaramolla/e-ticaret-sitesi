package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "favoriler")
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
}
