package com.company.controller;


import com.company.domain.Shop;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop/edit/")
@PreAuthorize("hasAuthority('ADMIN')")
public class ShopEditController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping
    public String shopEditList(Model model) {
        model.addAttribute("shops", shopRepository.findAll());
        return "/ShopList/shopEditList";
    }

    @GetMapping("{shop}")
    public String shopEditForm(@PathVariable Shop shop, Model model) {
        model.addAttribute("shop", shop);
        return "/ShopList/shopEdit";
    }

    @PostMapping
    public String shopSave(
            @RequestParam String shopname,
            @RequestParam("shopId") Shop shop
    ) {
        shop.setShopname(shopname);
        shopRepository.save(shop);
        return "redirect:/shop/edit/";
    }
}
