package ru.kulsha.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.kulsha")
public class AppConfiguration {
//    @Bean
//    public ProductRepositoryImpl productRepository() {
//        return new ProductRepositoryImpl();
//    }
//
//    @Bean
//    public ProductService productService(ProductRepository productRepository) {
//        return new ProductService(productRepository);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Cart cart() {
//        return new Cart();
//    }
}
