package ru.kulsha;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select product from Product product where product.title= :title", Product.class)
                            .setParameter("title", title)
                                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Product product) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }

    }

    @Override
    public void updatePriceById(Long id, int newPrice) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setPrice(newPrice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();

//            session.createQuery("DELETE FROM Product WHERE id = :id", Product.class);

            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
