package com.example.e_ticaret_sitesi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"sifre"})
@EqualsAndHashCode(of = {"id", "kullaniciAdi"})
@Entity
@Table(name = "kullanici")
public class Kullanici implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kullanici_adi", unique = true, nullable = false)
    private String kullaniciAdi;
    @Column(name = "eposta", unique = true, nullable = false)
    private String eposta;
    @Column(name = "sifre", nullable = false)
    private String sifre;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "kullanici_rolleri", joinColumns = @JoinColumn(name = "kullanici_id"))
    @Column(name = "rol")
    private Set<String> roller = new HashSet<>();

    private boolean aktif = true;

    private boolean hesapSuresiDolmamis = true;

    private boolean kilitliDegil = true;

    private boolean kimlikBilgileriSuresiDolmamis = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roller.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.sifre;
    }

    @Override
    public String getUsername() {
        return this.kullaniciAdi;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.hesapSuresiDolmamis;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.kilitliDegil;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.kimlikBilgileriSuresiDolmamis;
    }

    @Override
    public boolean isEnabled() {
        return this.aktif;
    }
}
