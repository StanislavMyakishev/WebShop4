package com.company.domain;

import javax.persistence.*;

@Entity
@Table(name="productshop")
public class ProductShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productshopid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public ProductShop() {
    }

    public ProductShop(Product product, Shop shop) {
        this.product = product;
        this.shop = shop;
    }

    public Integer getProductshopid() {
        return productshopid;
    }

    public void setProductshopid(Integer productshopid) {
        this.productshopid = productshopid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
