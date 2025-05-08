package com.example.e_ticaret_sitesi.dto;

// JSON'dan kullanıcı ve ürün ID'lerini almak için DTO
public class FavoriEkleDto {

    private Long kullaniciId;
    private Long urunId;

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
