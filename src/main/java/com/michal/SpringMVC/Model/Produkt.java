package com.michal.SpringMVC.Model;

import com.michal.SpringMVC.Validator.ProductId;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.math.BigDecimal;


public class Produkt {
    @Pattern(regexp = "P[0-9]+", message = " Błędny identyfikator produktu. Powinien składać się z litery P oraz liczby.")
    @ProductId
    private String productId;
    @Size(min = 2, max = 50, message = "Błędna nazwa produktu. Powinna mieć od 2 do 50 znaków")
    private String name;
    @Min(value=0, message="Błędna cena produktu. Cena nie może być ujemna.")
    @Digits(integer=8, fraction=2, message="Błędna cena produktu. Cena powinna składać się maksymalnie z 8 cyfr reprezentujących część całkowitą i 2 cyfr reprezentujących część ułamkową.")
    @NotNull(message= "Błędna cena produktu. Cena nie może być pusta.")
    private BigDecimal unitPrice;
    @Size(min = 1, message = "Błędny Opis. Podaj opis produktu.")
    private String description;
    private String manufacturer;
    @Size(min = 1, message = "Błędny kategoria. Podaj kategorie produktu.")
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    private MultipartFile productImage;


    public Produkt() {
        super();
    }

    public Produkt(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produkt other = (Produkt) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Produkt [productId=" + productId + ", nazwa=" + name + "]";
    }

    public String get() {
        return null;
    }
}
