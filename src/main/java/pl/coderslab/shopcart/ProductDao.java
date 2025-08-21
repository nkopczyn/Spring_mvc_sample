package pl.coderslab.shopcart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {

    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "apple", 3.99));
        products.add(new Product(2L, "banana", 2.5));
        products.add(new Product(3L, "pear", 8.20));

        return products;
    }


}
