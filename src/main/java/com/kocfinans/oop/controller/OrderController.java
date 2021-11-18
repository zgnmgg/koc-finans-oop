package com.kocfinans.oop.controller;

import com.kocfinans.oop.models.Order;
import com.kocfinans.oop.models.dto.OrderDTO;
import com.kocfinans.oop.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Qualifier("OrderController")
@RequestMapping("/order")
public class OrderController {

    private final IOrderService service;

    @PostMapping("/{menuId}/{clientId}")
    public ResponseEntity<Order> createOrder(
            @PathVariable("menuId") int menuId,
            @PathVariable("clientId") int cleintID,
            @RequestBody @Valid OrderDTO orderDTO) {

        //TODO user client token with principals
        return ResponseEntity.ok().body(this.service.create(menuId, cleintID, orderDTO));
    }

    @PostMapping("/pay/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrder(
            @PathVariable("orderId") int orderId) {
        this.service.payment(orderId);
    }
}
