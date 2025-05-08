package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.Kullanici;
import com.example.e_ticaret_sitesi.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class KullaniciDetayServisi implements UserDetailsService {

    private final KullaniciRepository kullaniciRepository;

    public KullaniciDetayServisi(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String eposta) throws UsernameNotFoundException {
        Kullanici kullanici = kullaniciRepository.findByEposta(eposta)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + eposta));

        return new User(
                kullanici.getEposta(),    // Username
                kullanici.getSifre(),     // Password
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Authority (ROLE_USER)
        );
    }
}
