package com.kocfinans.oop.service;

import com.kocfinans.oop.models.Order;
import com.kocfinans.oop.models.dto.OrderDTO;

public interface IOrderService {
    Order create(int menuId, int userClientId, OrderDTO dto);
    void payment(int orderId);
}
