package com.company.controller;


import com.company.domain.Product;
import com.company.domain.Shop;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/edit/")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductEditController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String productEditList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "/ProductList/productEditList";
    }

    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
        return "/ProductList/productEdit";
    }

    @PostMapping
    public String productSave(
            @RequestParam String productname,
            @RequestParam Double productcost,
            @RequestParam Integer productamount,
            @RequestParam("productId") Product product
    ) {
        product.setProductname(productname);
        product.setProductcost(productcost);
        product.setProductamount(productamount);
        productRepository.save(product);
        return "redirect:/product/edit/";
    }
}
