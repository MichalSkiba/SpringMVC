package com.michal.SpringMVC.Service.Impl;

import com.michal.SpringMVC.Model.Produkt;
import com.michal.SpringMVC.Repository.ProduktRepository;
import com.michal.SpringMVC.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProduktRepository produktRepository;

    public void processOrder(String productId, int count) {
        Produkt productById = produktRepository.getProductById(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
