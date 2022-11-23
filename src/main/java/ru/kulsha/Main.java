package ru.kulsha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
      try{
          ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

          productDao.updatePriceById(1L, 88);
          productDao.save(new Product());
          System.out.println(productDao.findAll());

      } catch (Exception e){
          e.printStackTrace();
      } finally {
          sessionFactoryUtils.shutdown();
      }
    }
}