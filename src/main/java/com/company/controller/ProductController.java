package com.company.controller;

import com.company.domain.Product;
import com.company.domain.ProductShop;
import com.company.domain.Shop;
import com.company.repository.ProductRepository;
import com.company.repository.ProductShopRepository;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/product")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductController {
    @Autowired
    private ProductShopRepository productShopRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String productList(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "/ProductList/productList";
    }

    @PostMapping
    public String productAdd(
            @RequestParam String productName,
            @RequestParam Double productCost,
            @RequestParam Integer productAmount,
            @RequestParam String shopName,
            Map<String, Object> model
    ) {
        Product product = new Product(productName, productCost, productAmount);
        Shop shopFromDB = shopRepository.findByShopname(shopName);
        if (shopFromDB == null){
            model.put("message", "THERE IS NO SUCH SHOP");
            return "/ProductList/productList";
        }
        productRepository.save(product);
        ProductShop productShop = new ProductShop(product, shopFromDB);
        productShopRepository.save(productShop);
        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);
        return "redirect:/product";
    }
}