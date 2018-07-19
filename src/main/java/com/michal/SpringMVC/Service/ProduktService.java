package com.michal.SpringMVC.Service;

import com.michal.SpringMVC.Model.Produkt;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProduktService {

    List<Produkt> getAllProducts();

    Produkt getProductById(String productID);

    List<Produkt> getProductsByCategory(String category);

    Set<Produkt> getProductsByFilter(Map<String, List<String>> filterParams);

    void addProduct(Produkt product);

}
