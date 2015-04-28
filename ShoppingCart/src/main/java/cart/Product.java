package cart;

import java.math.BigDecimal;

/**
 * Created by Suneel on 27/04/2015
 */
public class Product {

	private String name;
	private int quantity;
	private BigDecimal price = BigDecimal.valueOf(0.0);

	public Product(String name) {
		this.name = name;
		this.quantity = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
