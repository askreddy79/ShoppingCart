package cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Suneel on 27/04/2015
 */

public class CustomerBill {

	BigDecimal totalBill = new BigDecimal(0.0);

	public BigDecimal getTotalBill() {
		return totalBill;
	}

	/*
	 * Method scans all the products in the list
	 */
	public void visitShoppingCart(List<Product> shoppingProducts) {
		for (Product product : shoppingProducts) {
			visitCartProduct(product);
		}
		System.out.println("\n Amount to pay : £ " + totalBill);

	}

	/*
	 * Method calculates the product price and adds to totalbill
	 */
	public void visitCartProduct(Product product) {
		BigDecimal productCost = new BigDecimal(0.0);

		if (isProductExist(product)) {
			switch (ProductEnum.fromPropertyName(product.getName())) {
			case Apple:
				product.setPrice(ProductEnum.Apple.getPrice());
				break;
			case Orange:
				product.setPrice(ProductEnum.Orange.getPrice());
				break;
			}
			productCost = product.getPrice().multiply(
					BigDecimal.valueOf(product.getQuantity()));
			System.out.println(product.getQuantity() + " X "
					+ product.getName().toUpperCase() + " @ "
					+ product.getPrice() + "- £" + productCost);
			totalBill = totalBill.add(productCost);

		} else {
			throw new IllegalArgumentException("No such item in the stock");
		}

	}

	/*
	 * Method returns false for unknown items
	 */
	private boolean isProductExist(Product product) {
		boolean productExist = true;

		if (ProductEnum.fromPropertyName(product.getName()) == null) {
			productExist = false;
		}

		return productExist;
	}

}
