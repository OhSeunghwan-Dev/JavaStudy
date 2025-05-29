package product.controller;

import java.util.ArrayList;

import product.model.Product;
import product.service.ProductService;

public class ProductController {

	ProductService productService = new ProductService();
	
	public ArrayList<Product> getProductList() {
		return productService.getProductList();
	}

	public Product getProduct(int index) {
		return productService.getProduct(index);
	}

	public boolean isSale(Product product) {
		return productService.isSale(product);
	}

	public void updateProduct(Product product) {
		productService.updateProduct(product);
	}

	public void addProduct(Product product) {
		productService.addProduct(product);
	}

	public ArrayList<Product> getProduct(String name) {
		return productService.getProduct(name);
	}

	public void deleteProduct(Product product) {
		productService.deleteProduct(product);
	}

}
