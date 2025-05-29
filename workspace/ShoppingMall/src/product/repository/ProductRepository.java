package product.repository;

import java.util.ArrayList;

import member.model.Member;
import product.model.Product;

public class ProductRepository {
	
	private static ProductRepository productRepository = null;
	private ArrayList<Product> productList = new ArrayList<>();
	
	// private 생성자
	private ProductRepository() {}	
	
	// 싱글톤 패턴 - 객체 단일화하기 (DataBase)
	public static ProductRepository getInstance() {
		if (productRepository == null) {
			productRepository = new ProductRepository();
		}
		
		return productRepository;
	}
	
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}

	public Product getProduct(int index) {
		return productList.get(index);
	}

	public void updateProduct(Product product) {
	
		int index = 0;
		
		for (Product oneProduct : productList) {
			if (product == oneProduct) {
				productList.set(index, product);
				break;
			}
			index++;
		}
	}

	public void deleteProduct(Product product) {
		
		for (Product oneProduct : productList) {
			if (product == oneProduct) {
				productList.remove(product);
				break;
			}
		}
	}

}
