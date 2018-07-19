package com.michal.SpringMVC.Validator;

import com.michal.SpringMVC.Model.Produkt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class UnitsInStockValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Produkt.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Produkt product = (Produkt) target;
        if (product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0 && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "Nie możesz dodać więcej niż 99 sztuk towaru o cenie wyższej niż 10000");
        }
    }
}

