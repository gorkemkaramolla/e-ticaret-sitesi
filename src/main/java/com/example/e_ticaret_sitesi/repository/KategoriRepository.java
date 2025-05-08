package com.example.e_ticaret_sitesi.repository;

import com.example.e_ticaret_sitesi.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {

}
