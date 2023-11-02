package com.dscommerce.dscommerce.tests;

import com.dscommerce.dscommerce.entities.Category;
import com.dscommerce.dscommerce.entities.Product;

public class ProductFactory {
    public static Product createProduct() {
        Category category = CategoryFactory.createCategory();
        Product product = new Product(1L, "Playstation", "description", 3000.0, "https://image.com");
        product.getCategories().add(category);
        return product;
    }
    public static Product createProduct(String name) {
        Product product = createProduct();
        product.setName(name);
        return product;
    }
}
