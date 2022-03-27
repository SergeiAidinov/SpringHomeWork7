package ru.yandex.incoming34.SpringHomeWork7.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.lang.NonNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Authorization;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import ru.yandex.incoming34.SpringHomeWork7.dto.ProductDto;
import ru.yandex.incoming34.SpringHomeWork7.entities.Product;
import ru.yandex.incoming34.SpringHomeWork7.repos.ProductRepo;

@RestController
@RequestMapping("/api/pruducts")
//@SecurityRequirement(name = "mySchema")
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@GetMapping("/user/all")
	public Iterable<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@GetMapping("/user/product-by-id")
	public Optional<Product> getProductById(@NonNull Long productId) {
		return productRepo.findById(productId);
	}

	
	@PostMapping("/admin/new-product")
	public void newProduct(@NonNull ProductDto productDto) {
		Product product = new Product(productDto);
		productRepo.save(product);
	}
	
	//@Secured(value = "ADMIN")
	//@Authorization(value = "ADMIN")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/admin/deleting-product-by-id/{productId}")
	public String deleteProduct(@NonNull @PathVariable Long productId) {
		try {
			productRepo.deleteById(productId);
			return "Сущность удалена";
		} catch (EmptyResultDataAccessException e) {
			return "Сущности с таким Id не существует";
		}
	}

}
