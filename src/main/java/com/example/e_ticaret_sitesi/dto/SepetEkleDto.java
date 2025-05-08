package com.example.e_ticaret_sitesi.dto;

public class SepetEkleDto {

    private Long kullaniciId;
    private Long urunId;

    // Getter ve Setter
    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }
}
