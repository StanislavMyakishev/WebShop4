package com.company.controller;

import com.company.domain.Shop;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/shop")
@PreAuthorize("hasAuthority('ADMIN')")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping
    public String shopList(Model model) {
        model.addAttribute("shops", shopRepository.findAll());
        return "/ShopList/shopList";
    }

    @PostMapping
    public String shopAdd(
            @RequestParam String shopName, Map<String, Object> model
    ) {
        Shop shop = new Shop(shopName);
        shopRepository.save(shop);
        Iterable<Shop> shops = shopRepository.findAll();
        model.put("shops", shops);
        return "redirect:/shop";
    }
}