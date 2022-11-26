package ru.kulsha;

import java.util.List;

public interface OrderDao {
    List<Product> getPurchasedProducts(Long userId);

    List<User> getCustomersListForTisProduct(Long productId);
}
