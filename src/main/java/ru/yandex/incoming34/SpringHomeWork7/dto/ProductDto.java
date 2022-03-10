package ru.yandex.incoming34.SpringHomeWork7.dto;

public class ProductDto {
	
	private String productName;
	
	public ProductDto(String productName, Integer productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
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

	private Integer productPrice;

}
