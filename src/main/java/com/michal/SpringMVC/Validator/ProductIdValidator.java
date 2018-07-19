package com.michal.SpringMVC.Validator;

import com.michal.SpringMVC.Exception.ProductNotFoundException;
import com.michal.SpringMVC.Model.Produkt;
import com.michal.SpringMVC.Service.ProduktService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    @Autowired
    private ProduktService produktService;


    public void initialize(ProductId constraintAnnotation) {
        //  celowo pozostawione puste; w tym miejscu nale�y zainicjowa� adnotacj� ograniczaj�c� do sensownych domy�lnych w
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        Produkt produkt;
        try {
            produkt = produktService.getProductById(value);

        } catch (ProductNotFoundException e) {
            return true;
        }

        if (produkt != null) {
            return false;
        }

        return true;
    }

}