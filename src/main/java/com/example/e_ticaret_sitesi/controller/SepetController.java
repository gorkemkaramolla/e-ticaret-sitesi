package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.entity.Urun;
import com.example.e_ticaret_sitesi.entity.UrunSepet;
import com.example.e_ticaret_sitesi.service.SepetService;
import com.example.e_ticaret_sitesi.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sepet")
public class SepetController {

    private final SepetService sepetService;
    private final UrunService urunService;

    @Autowired
    public SepetController(SepetService sepetService, UrunService urunService) {
        this.sepetService = sepetService;
        this.urunService = urunService;
    }
    @PostMapping("/ekle")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                            HttpServletRequest request) {

        Optional<Urun> optionalUrun = urunService.findById(productId);

        if (optionalUrun.isPresent()) {
            sepetService.addProduct(optionalUrun.get(), quantity);
        } else {
            return "redirect:/urunler?error=productNotFound";
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/urunler");
    }

    @GetMapping("/liste")
    public List<UrunSepet> viewCartList() {
        return sepetService.getItems();
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", sepetService.getItems());
        model.addAttribute("total", sepetService.getTotal());
        return "sepet";
    }

    @PostMapping("/sil")
    public String removeFromCart(@RequestParam("productId") Long productId) {
        sepetService.removeProduct(productId);
        return "redirect:/sepet";
    }
}
