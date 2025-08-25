package com.example.fpisfondrum.service.order;

import com.example.fpisfondrum.model.Order;
import com.example.fpisfondrum.model.OrderWine;
import com.example.fpisfondrum.model.Wine;
import com.example.fpisfondrum.request.OrderRequest;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    public void save(List<OrderRequest> order);
}
