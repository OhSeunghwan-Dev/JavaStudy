package product.model;

import java.util.Objects;

public class Product {
	
	private static int primaryKey = 1;	// autoincrement.
	private int id;		// pk
	private String name;
	private int price;
	private int saleRatio;
	
	public Product() {}
	
	public Product(String name, int price, int saleRatio) {
		id = primaryKey++;
		this.name = name;
		this.price = price;
		this.saleRatio = saleRatio;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(int saleRatio) {
		this.saleRatio = saleRatio;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // id 필드의 해시코드를 반환한다.
    }
}
