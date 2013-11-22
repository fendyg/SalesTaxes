import static org.junit.Assert.*;

import org.junit.Test;


public class GoodsTest {

	@Test
	public void testCreateGoods() {
		//create dummy goods
		Goods tester = new Goods("book", 1, 12.49);
		
		//check if itemName equals book
		assertEquals("book",tester.getItemName());
	}
	
	@Test
	public void testTaxCalculation() {
		//Create dummy goods
		Goods tester = new Goods("imported bottle of perfume", 1, 47.50);
		
		//check if item tax returns 7.15
		assertEquals(7.15, tester.getItemTax(), 0);
	}
	
	@Test
	public void testImportedTaxCalculation() {
		//Create dummy goods
		Goods tester = new Goods("imported box of chocolate", 1, 10.00);
		
		//check if item tax equals 0.5
		assertEquals(0.5, tester.getItemTax(), 0);
	}
	
	@Test
	public void testBasicTaxCalculation() {
		//create dummy goods
		Goods tester = new Goods("music CD", 1, 14.99);
		
		//check if item tax equals 1.50
		assertEquals(1.5, tester.getItemTax(), 0);
	}
	
	@Test
	public void testItemTotalPriceCalculation() {
		//create dummy goods
		Goods tester = new Goods("box of imported chocolates", 1, 11.25);
		
		//check if item total price equals 11.85
		assertEquals(11.85, tester.getTotalPrice(), 0);
	}

}
