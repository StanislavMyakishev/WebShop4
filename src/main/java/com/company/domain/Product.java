package com.company.domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productid;

    private String productname;

    private Double productcost;

    private Integer productamount;

    public Product() {
    }

    public Product(String productname, Double productcost, Integer productamount ) {
        this.productname = productname;
        this.productcost = productcost;
        this.productamount = productamount;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductcost() {
        return productcost;
    }

    public void setProductcost(Double productcost) {
        this.productcost = productcost;
    }

    public Integer getProductamount() {
        return productamount;
    }

    public void setProductamount(Integer productamount) {
        this.productamount = productamount;
    }
}
