package ru.yandex.incoming34.SpringHomeWork7.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ru.yandex.incoming34.SpringHomeWork7.dto.ProductDto;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private Integer productPrice;
	
	public Product() {
		
	};
	
	public Product(ProductDto productDto){
		productName = productDto.getProductName();
		productPrice = productDto.getProductPrice();
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
}
