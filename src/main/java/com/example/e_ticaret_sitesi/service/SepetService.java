package com.example.e_ticaret_sitesi.service;

import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.entity.UrunSepet;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope // Creates a unique cart per user session
@Getter
@Setter
public class SepetService {

    private List<UrunSepet> items = new ArrayList<>();

    public void addProduct(Urun urun, int quantity) {
        Optional<UrunSepet> existingItem = items.stream()
                .filter(item -> item.getUrun().getId().equals(urun.getId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            if (quantity > 0) {
                items.add(new UrunSepet(urun, quantity));
            }
        }
    }

    public void removeProduct(Long urunId) {
        items.removeIf(item -> item.getUrun().getId().equals(urunId));
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(UrunSepet::getSubtotal)
                .sum();
    }

    public void clearCart() {
        items.clear();
    }

    public int getItemCount() {
        return items.stream().mapToInt(UrunSepet::getQuantity).sum();
    }
}
