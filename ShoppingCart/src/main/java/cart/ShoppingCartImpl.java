package cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suneel on 27/04/2015
 */

public class ShoppingCartImpl implements ShoppingCart{
	
	
	private List<Product> shoppingProducts = new ArrayList<Product>();
	private CustomerBill customer = new CustomerBill();
	
	public BigDecimal getTotalBill() {
		return customer.getTotalBill();
	}

	public List<Product> getShoppingProducts() {
		return shoppingProducts;
	}

	
	@Override
	public void checkOut(String listOfProducts) {
		String[] products = listOfProducts.split("\\s");		
		for(String productName: products)
		{
			shoppingProducts.add(new Product(productName));
		}
		
		customer.visitShoppingCart(shoppingProducts);
	}


}
