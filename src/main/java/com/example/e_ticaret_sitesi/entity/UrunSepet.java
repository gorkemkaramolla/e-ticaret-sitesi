package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UrunSepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Urun urun;
    @ManyToOne(optional = false)
    private Sepet sepet;
    private int quantity;

    public UrunSepet(Urun urun, int quantity) {
        this.urun = urun;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return urun.getFiyat() * quantity;
    }
}
