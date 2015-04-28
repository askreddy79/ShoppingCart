package cart;

import java.math.BigDecimal;

/**
 * Created by Suneel on 27/04/2015
 */

public enum ProductEnum {
	Apple("Apple", 0.60), Orange("Orange", 0.25);

	private final String name;
	private final double price;

	private ProductEnum(final String name, final double price) {
		this.name = name;
		this.price = price;
	}

	public String getPropertyName() {
		return name;
	}

	public static ProductEnum fromPropertyName(String value) {
		for (ProductEnum product : ProductEnum.values()) {
			if (value.equalsIgnoreCase(product.getPropertyName())) {
				return product;
			}
		}
		return null;
	}

	public BigDecimal getPrice() {
		return BigDecimal.valueOf(price);
	}

}
