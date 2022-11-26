package ru.kulsha;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kulsha.config.AppConfiguration;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

      try{
          OrderDao orderDao = new OrderDaoImpl(sessionFactoryUtils);

          List<Product> products = orderDao.getPurchasedProducts(2L);
          System.out.println("*******************************");
          System.out.println(products);
          System.out.println("*******************************");

      } catch (Exception e){
          e.printStackTrace();
      } finally {
          sessionFactoryUtils.shutdown();
      }
    }
}