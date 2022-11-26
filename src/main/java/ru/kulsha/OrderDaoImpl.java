package ru.kulsha;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderDaoImpl implements OrderDao{

    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public OrderDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> getPurchasedProducts(Long userId) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            System.out.println(user.getProducts());
            session.getTransaction().commit();
            return user.getProducts();
        }
    }

    @Override
    public List<User> getCustomersListForTisProduct(Long productId) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            System.out.println(product.getUsers());
            session.getTransaction().commit();
            return product.getUsers();
        }
    }
}
