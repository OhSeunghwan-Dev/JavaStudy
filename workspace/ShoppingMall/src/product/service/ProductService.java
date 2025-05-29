package product.service;

import java.util.ArrayList;

import product.model.Product;
import product.repository.ProductRepository;

public class ProductService {

	ProductRepository productRepository = ProductRepository.getInstance();
	
	public ArrayList<Product> getProductList() {
		return productRepository.getProductList();
	}

	public Product getProduct(int index) {
		return productRepository.getProduct(index);
	}

	public boolean isSale(Product product) {
		
		if (product.getSaleRatio() > 0) {
			return true;
		}
		return false;
	}

	public void updateProduct(Product product) {
	
		productRepository.updateProduct(product);
	}

	public void addProduct(Product product) {
		
		productRepository.addProduct(product);
	}

	public ArrayList<Product> getProduct(String name) {
		
		ArrayList<Product> deleteList = new ArrayList<>();
		ArrayList<Product> list = getProductList();
		
		for (Product product : list) {
			if (product.getName().equals(name)) {
				deleteList.add(product);
			}
		}
		return deleteList;
	}

	public void deleteProduct(Product product) {
		productRepository.deleteProduct(product);
	}

	
}
