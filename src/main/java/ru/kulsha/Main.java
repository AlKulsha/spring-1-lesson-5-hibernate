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

          System.out.println(productDao.findAll());
          productDao.deleteById(2L);
          System.out.println(productDao.findAll());

      } catch (Exception e){
          e.printStackTrace();
      } finally {
          sessionFactoryUtils.shutdown();
      }
    }
}