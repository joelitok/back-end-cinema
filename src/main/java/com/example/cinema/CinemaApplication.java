package com.example.cinema;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.cinema.dao.ProductRepository;
import com.example.cinema.entities.Product;


//@SpringBootApplication(scanBasePackages = {"com.example.cinema.*"})
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CinemaApplication implements CommandLineRunner{
   
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
 
	@Override
public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Product.class);
productRepository.save(new Product(null,"ordinateur",12,3));
productRepository.save(new Product(null,"telephone",12,3));
productRepository.save(new Product(null,"phone",12,3));
productRepository.findAll().forEach(p->{
	System.out.println(p.toString());
	
});		
	}

}
