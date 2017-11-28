package org.itstep;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class GoodsCheckerTest {

	Logger logger = Logger.getLogger(GoodsCheckerTest.class.getName());
	
	@Test
	public void testCheckDiscount() {
	}

	@Test
	public void testFormatMoney() {
		GoodsChecker checker = new GoodsChecker();
		int testPrice = 12345;
		String priceAsText = checker.formatMoney(testPrice);
		assertEquals("123,45 UAH", priceAsText);
		logger.log(Level.SEVERE, "Test");
	}

}
