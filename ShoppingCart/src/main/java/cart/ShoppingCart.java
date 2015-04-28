package cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Suneel on 27/04/2015
 */

public interface ShoppingCart {

	public List<String> getShoppingProducts();

	public void checkOut(String listOfProducts);

	public BigDecimal getTotalBill();

}
