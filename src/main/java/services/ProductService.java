package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cinema.dao.ProductRepository;
import com.example.cinema.entities.Product;

public class ProductService {
	
    @Autowired
	private ProductRepository productRepository;
	
	//pour affichier la liste de produit 
	@GetMapping(value="/listproducts")
	public List<Product> listProducts(){
		return productRepository.findAll();
		}
	
	//pour cette un produit specifique
	@GetMapping(value="/listproducts/{id}")
	public Product listProducts(@PathVariable(name="id") Long id){
		return productRepository.findById(id).get();
		}
	
	//pour modifier un element de la liste
	@PutMapping(value="/listproducts/{id}")
	public Product update(@PathVariable(name="id") Long id, @RequestBody Product p){
		p.setId(id);
		return productRepository.save(p);
		}
	
	//pour enregistrer un nouveau produit
	@PostMapping(value="/listproducts")
	public Product save(@RequestBody Product p){
		return productRepository.save(p);
		}
	
	//pour supprimer un produit
	@DeleteMapping(value="/listproducts/{id}")
	public void delete(@PathVariable(name="id") Long id){
		productRepository.deleteById(id);
		}
	
	
	
	
	
}
