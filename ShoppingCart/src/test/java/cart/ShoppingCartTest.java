package cart;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Suneel on 27/04/2015
 */
public class ShoppingCartTest {

	ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCartImpl();
	}

	@Test
	public void testShoppingCartEmpty() {
		assertThat(shoppingCart.getShoppingProducts().size(), Is.is(0));
	}

	@Test
	public void testOnlyOneProductInCart() {
		shoppingCart.checkOut("Apple");
		assertThat(shoppingCart.getShoppingProducts().size(), Is.is(1));
	}

	@Test
	public void testTwoProductsInCart() {
		shoppingCart.checkOut("Apple Orange");
		assertThat(shoppingCart.getShoppingProducts().size(), Is.is(2));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnknownProduct() {
		shoppingCart.checkOut("Apple Orange Banana Apple");
		assertThat(shoppingCart.getTotalBill().doubleValue(), Is.is(2.80));
	}

	@Test
	public void testDiscountOnOranges() {
		shoppingCart
				.checkOut("Orange Orange Orange Orange Orange Orange Orange Orange");
		assertThat(shoppingCart.getTotalBill().doubleValue(), Is.is(1.50));
	}

	@Test
	public void testDiscountOnApple() {
		shoppingCart.checkOut("Apple Apple Apple Apple Apple");
		assertThat(shoppingCart.getTotalBill().doubleValue(), Is.is(1.80));
	}

	@Test
	public void testDiscountOnApplesAndOranges() {
		shoppingCart.checkOut("Orange Orange Orange Orange Orange Apple Apple");
		assertThat(shoppingCart.getTotalBill().doubleValue(), Is.is(1.60));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDiscountOnEmpty() {
		shoppingCart.checkOut("");
		assertThat(shoppingCart.getTotalBill().doubleValue(), Is.is(0.0));
	}

}
