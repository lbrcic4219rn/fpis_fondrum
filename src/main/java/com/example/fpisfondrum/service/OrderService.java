package com.example.fpisfondrum.service;

import com.example.fpisfondrum.model.Order;
import com.example.fpisfondrum.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }
}
