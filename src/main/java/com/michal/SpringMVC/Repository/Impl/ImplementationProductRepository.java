package com.michal.SpringMVC.Repository.Impl;

import com.michal.SpringMVC.Exception.ProductNotFoundException;
import com.michal.SpringMVC.Model.Produkt;
import com.michal.SpringMVC.Repository.ProduktRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.Integer.parseInt;

@Repository
public class ImplementationProductRepository implements ProduktRepository {


    private List<Produkt> listOfProducts = new ArrayList<Produkt>();

    public ImplementationProductRepository() {
        Produkt iphone = new Produkt("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 6401136 i 8-megapikselowym aparatem");
        iphone.setCategory("Smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Produkt laptop_dell = new Produkt("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Produkt tablet_Nexus = new Produkt("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);
        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    public List<Produkt> getAllProducts() {
        return listOfProducts;
    }

    public Produkt getProductById(String productId) {
        Produkt productById = null;
        for (Produkt product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new ProductNotFoundException(productId);
        }
        return productById;
    }

    public List<Produkt> getProductsByCategory(String category) {
        List<Produkt> productsByCategory = new ArrayList<Produkt>();
        for (Produkt product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Set<Produkt> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Produkt> produktsByBrand = new HashSet<Produkt>();
        Set<Produkt> produktsByCategory = new HashSet<Produkt>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Produkt produkt : listOfProducts) {
                    if (brandName.equalsIgnoreCase(produkt.getManufacturer())) {
                        produktsByBrand.add(produkt);
                    }
                }
            }
        }
        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                produktsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        produktsByCategory.retainAll(produktsByBrand);
        return produktsByCategory;
    }

    public void addProduct(Produkt product) {
        listOfProducts.add(product);
    }

}
