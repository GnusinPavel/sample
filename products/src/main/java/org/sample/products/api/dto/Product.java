package org.sample.products.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
    @NotBlank(message = "Product name must not be null or empty")
    @ApiModelProperty(name = "Product name", example = "milk")
    private String name;

    @NotNull(message = "Product code must not be null")
    @Size(message = "Product code must be 13 symbols", min = 13, max = 13)
    @ApiModelProperty(name = "Product code", example = "2364758363546")
    private String code;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }
}
