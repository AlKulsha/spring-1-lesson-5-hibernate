package ru.kulsha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
    private static SessionFactory factory;

    public static void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown(){
        if(factory != null){
            factory.close();
        }
    }


    public static void main(String[] args) {
      try{
          init();
          Session session = factory.getCurrentSession();
          session.beginTransaction();
          User oldUser = session.get(User.class, 1L);
          oldUser.print();
          session.getTransaction().commit();
      } catch (Exception e){
          e.printStackTrace();
      } finally {
          shutdown();
      }
    }
}