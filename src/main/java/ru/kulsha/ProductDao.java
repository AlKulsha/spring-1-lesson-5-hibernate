package ru.kulsha;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    Product findByTitle(String title);
    List<Product> findAll();
    void save(Product product);
    void  updatePriceById (Long id, int price);

    void deleteById(Long id);
}
