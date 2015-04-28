package cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Suneel on 27/04/2015
 */

public class CustomerBill {

	BigDecimal totalBill = new BigDecimal(0.0);
	int quantityOfApples = 0;
	int quantityOfOranges = 0;

	public BigDecimal getTotalBill() {

		BigDecimal priceOfOranges = new BigDecimal(0.0);
		BigDecimal priceOfApples = new BigDecimal(0.0);

		/*
		 * Price of the apples with discount. Eg: for 7 apples , 6 apples can be
		 * priced as half of the price the remaining 1 apple can be priced as
		 * original price. 7 apples = ((6/2)+1) * 0.60 6 apples = (6/2) * 0.60
		 */
		priceOfApples = (quantityOfApples % 2 == 0) ? priceOfApples
				.add(ProductEnum.Apple.getPrice().multiply(
						BigDecimal.valueOf(quantityOfApples / 2))) : priceOfApples
				.add(ProductEnum.Apple.getPrice().multiply(
						BigDecimal.valueOf(quantityOfApples / 2 + 1)));

		/*
		 * Price of the Oranges with discount. Eg: for 11 oranges , 9 oranges
		 * can be divided into 3 sets and charged each set can be priced as two
		 * oranges original price remaining 2 oranges can be priced as original
		 * price. 11 oranges = 3 * 0.25 * 2 + 2 * 0.25 = 2.0
		 */
		priceOfOranges = (quantityOfOranges % 3 == 0) ? priceOfOranges
				.add(ProductEnum.Orange.getPrice()
						.multiply(BigDecimal.valueOf(2))
						.multiply(BigDecimal.valueOf(quantityOfOranges / 3)))
				: priceOfOranges.add(
						ProductEnum.Orange.getPrice()
								.multiply(BigDecimal.valueOf(2))
								.multiply(BigDecimal.valueOf(quantityOfOranges / 3)))
						.add(ProductEnum.Orange.getPrice().multiply(
								BigDecimal.valueOf(quantityOfOranges % 3)));

		totalBill = totalBill.add(priceOfApples).add(priceOfOranges);
		System.out.println("\n Amount to pay : £ " + totalBill);
		return totalBill;
	}

	/*
	 * Method scans all the products in the list
	 */
	public void visitShoppingCart(List<String> shoppingProducts) {
		for (String product : shoppingProducts) {
			visitCartProduct(product);
		}

	}

	/*
	 * Method calculates each product quantities
	 */
	public void visitCartProduct(String product) {
		if (isProductExist(product)) {
			switch (ProductEnum.fromPropertyName(product)) {
			case Apple:
				quantityOfApples += 1;
				break;
			case Orange:
				quantityOfOranges += 1;
				break;

			}
		} else {
			throw new IllegalArgumentException("No such item in the stock");
		}

	}

	/*
	 * Method returns false for unknown items
	 */
	private boolean isProductExist(String product) {
		boolean productExist = true;

		if (ProductEnum.fromPropertyName(product) == null) {
			productExist = false;
		}

		return productExist;
	}

}
