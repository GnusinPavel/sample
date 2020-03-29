package org.sample.products.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Order {

    @NotNull(message = "Seller must not be null")
    @Size(message = "Seller must be 9 symbols", min = 9, max = 9)
    @ApiModelProperty(name = "Seller code", example = "123534251")
    private String seller;

    @NotNull(message = "Customer must not be null")
    @Size(message = "Customer must be 9 symbols", min = 9, max = 9)
    @ApiModelProperty(name = "Customer code", example = "648563524")
    private String customer;

    @NotEmpty(message = "Product list must not be null or empty")
    @Valid
    @ApiModelProperty(name = "List of products")
    private List<Product> products;

    public String getSeller() {
        return seller;
    }

    public Order setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Order setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Order setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
