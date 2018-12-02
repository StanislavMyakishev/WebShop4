package com.company.repository;

import com.company.domain.ProductShop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductShopRepository extends CrudRepository<ProductShop, Integer> {
    List<ProductShop> findAll();
}
