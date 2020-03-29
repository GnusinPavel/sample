package org.sample.products.api;

import io.swagger.annotations.ApiOperation;
import org.sample.products.api.dto.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    @ApiOperation("Makes an Order")
    public Order createOrder(@Valid @RequestBody Order order) {
        // TODO: some useful logic
        return order;
    }
}
