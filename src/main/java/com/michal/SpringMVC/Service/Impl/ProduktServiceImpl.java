package com.michal.SpringMVC.Service.Impl;

import com.michal.SpringMVC.Model.Produkt;
import com.michal.SpringMVC.Repository.ProduktRepository;
import com.michal.SpringMVC.Service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProduktServiceImpl implements ProduktService {

    @Autowired
    private ProduktRepository produktRepository;


    public List<Produkt> getAllProducts() {
        return produktRepository.getAllProducts();
    }

    public Produkt getProductById(String productID) {
        return produktRepository.getProductById(productID);
    }

    public List<Produkt> getProductsByCategory(String category) {
        return produktRepository.getProductsByCategory(category);
    }

    public Set<Produkt> getProductsByFilter(Map<String, List<String>> filterParams) {
        return produktRepository.getProductsByFilter(filterParams);
    }
    public void addProduct(Produkt product) {
        produktRepository.addProduct(product);
    }
}
