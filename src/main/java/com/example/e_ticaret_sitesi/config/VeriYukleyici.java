package com.example.e_ticaret_sitesi.config;

import com.example.e_ticaret_sitesi.entity.Kategori;
import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.repository.KategoriRepository;
import com.example.e_ticaret_sitesi.repository.UrunRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class VeriYukleyici {

    @Bean
    CommandLineRunner veriYukle(KategoriRepository kategoriRepo, UrunRepository urunRepo) {
        return args -> {

            // Kategorileri oluştur
            Kategori telefon = new Kategori("Telefon");
            Kategori tablet = new Kategori("Tablet");
            Kategori masaustu = new Kategori("Masaüstü Bilgisayar");
            Kategori dizustu = new Kategori("Dizüstü Bilgisayar");
            Kategori kulaklik = new Kategori("Kulaklık");
            Kategori televizyon = new Kategori("Televizyon");

            kategoriRepo.saveAll(Arrays.asList(telefon, tablet, masaustu, dizustu, kulaklik, televizyon));

            // Ürünleri ekle (örnek resim URL'leri ile)
            urunRepo.saveAll(Arrays.asList(
                    new Urun("iPhone 14", "Apple’ın 2022 modeli. Güçlü işlemci ve kamera.", 42999, "https://cdn.example.com/images/iphone14.jpg", telefon),
                    new Urun("iPhone 15", "Dynamic Island ve yeni nesil A16 Bionic çip.", 52999, "https://cdn.example.com/images/iphone15.jpg", telefon),
                    new Urun("Samsung S22", "Samsung’un amiral gemisi. AMOLED ekranlı.", 31999, "https://cdn.example.com/images/samsung_s22.jpg", telefon),
                    new Urun("Samsung S23 Ultra", "200MP kamera, Snapdragon işlemci.", 58999, "https://cdn.example.com/images/samsung_s23_ultra.jpg", telefon),
                    new Urun("Xiaomi 13T Pro", "Hızlı şarj, 1.5K ekran, Leica kameralı.", 21999, "https://cdn.example.com/images/xiaomi_13t.jpg", telefon),
                    new Urun("Realme GT Neo 5", "240W süper hızlı şarj destekli.", 18999, "https://cdn.example.com/images/realme_gt_neo5.jpg", telefon),
                    new Urun("Asus ROG Phone 6", "Oyun telefonu. 165Hz AMOLED ekran.", 29999, "https://cdn.example.com/images/asus_rog_phone6.jpg", telefon),

                    new Urun("iPad 10. Nesil", "10.9 inç ekranlı, USB-C girişli model.", 18999, "https://cdn.example.com/images/ipad10.jpg", tablet),
                    new Urun("iPad Air M1", "M1 çipli, çok hafif ve ince.", 23999, "https://cdn.example.com/images/ipad_air_m1.jpg", tablet),
                    new Urun("Samsung Tab S8", "S Pen destekli, 120Hz ekranlı.", 20999, "https://cdn.example.com/images/samsung_tabs8.jpg", tablet),
                    new Urun("Xiaomi Pad 6", "Snapdragon 870 işlemcili tablet.", 13999, "https://cdn.example.com/images/xiaomi_pad6.jpg", tablet),
                    new Urun("Lenovo Tab P11 Pro", "OLED ekran, Dolby sesli model.", 11999, "https://cdn.example.com/images/lenovo_tab_p11.jpg", tablet),

                    new Urun("Apple iMac M3 2023", "24 inç 4.5K Retina ekranlı iMac.", 49999, "https://cdn.example.com/images/imac_m3.jpg", masaustu),
                    new Urun("Casper Nirvana Masaüstü", "Intel i5, 8GB RAM, SSD diskli.", 17499, "https://cdn.example.com/images/casper_nirvana.jpg", masaustu),
                    new Urun("Lenovo AIO 3", "All-in-one ekranlı bilgisayar.", 18499, "https://cdn.example.com/images/lenovo_aio3.jpg", masaustu),
                    new Urun("Asus A3402", "FHD ekran, Intel UHD grafik kartlı.", 19499, "https://cdn.example.com/images/asus_a3402.jpg", masaustu),

                    new Urun("MacBook Air M2", "M2 çip, ultra hafif, 18 saat pil ömrü.", 45999, "https://cdn.example.com/images/macbook_air_m2.jpg", dizustu),
                    new Urun("MacBook Pro M3", "Pro çipli, Touch Bar destekli model.", 67999, "https://cdn.example.com/images/macbook_pro_m3.jpg", dizustu),
                    new Urun("Acer Aspire 7", "GTX1650 ekran kartı ile oyun odaklı.", 18999, "https://cdn.example.com/images/acer_aspire7.jpg", dizustu),
                    new Urun("Asus TUF A15", "AMD Ryzen 7 işlemcili güçlü laptop.", 21999, "https://cdn.example.com/images/asus_tuf_a15.jpg", dizustu),
                    new Urun("HP Pavilion 15", "Intel i7 13. nesil, SSD’li.", 20999, "https://cdn.example.com/images/hp_pavilion15.jpg", dizustu),

                    new Urun("JBL Tune 760NC", "Kablosuz, ANC destekli kulaklık.", 3499, "https://cdn.example.com/images/jbl_tune_760nc.jpg", kulaklik),
                    new Urun("AirPods 3", "Apple’ın uzamsal ses destekli modeli.", 5999, "https://cdn.example.com/images/airpods3.jpg", kulaklik),
                    new Urun("Huawei FreeBuds 5i", "Su geçirmez, ANC özelliği var.", 2799, "https://cdn.example.com/images/huawei_freebuds5i.jpg", kulaklik),
                    new Urun("Sony WH-1000XM5", "Premium ANC, 30 saat pil ömrü.", 9499, "https://cdn.example.com/images/sony_wh1000xm5.jpg", kulaklik),

                    new Urun("Samsung QLED 55Q60B", "4K, HDR10+, Smart TV.", 27499, "https://cdn.example.com/images/samsung_qled_55.jpg", televizyon),
                    new Urun("Vestel 65UA9600", "Ultra HD, yerli üretim, Smart TV.", 20999, "https://cdn.example.com/images/vestel_65ua9600.jpg", televizyon),
                    new Urun("Philips Ambilight", "Ambilight teknolojili televizyon.", 25999, "https://cdn.example.com/images/philips_ambilight.jpg", televizyon),
                    new Urun("LG OLED C2", "Gerçek siyahlar, OLED panel.", 39999, "https://cdn.example.com/images/lg_oled_c2.jpg", televizyon)
            ));
        };
    }
}
