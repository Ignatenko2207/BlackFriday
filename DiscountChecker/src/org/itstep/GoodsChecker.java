package org.itstep;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodsChecker {

	public static Logger logger = Logger.getLogger(GoodsChecker.class.getName());

	public ArrayList<Good> checkDiscount(ArrayList<Good> goods) {
		int totalPrice = 0;
		for (Good good : goods) {
			totalPrice = totalPrice + good.getPrice();
			// totalPrice += good.getPrice();

		}
		logger.log(Level.INFO, "Total price before discount check is " + formatMoney(totalPrice));
		goods = getSortedGoods(goods);
		int counter = 1;
		for (int i = 1; i < goods.size(); i++) {
			if (goods.get(i).getCode().equals(goods.get(i - 1).getCode())) {
				counter++;
			} else {
				counter = 1;
			}

			if (counter % 3 == 0 && goods.get(i).getPrice() == goods.get(i - 1).getPrice()) {
				int newPrice = goods.get(i).getPrice() / 2;
				goods.get(i).setPrice(newPrice);
			}
		}
		totalPrice = 0;
		for (Good good : goods) {
			totalPrice = totalPrice + good.getPrice();
		}
		logger.log(Level.INFO, "Total price after discount check is " + formatMoney(totalPrice));
		return goods;
	}

	private ArrayList<Good> getSortedGoods(ArrayList<Good> goods) {
		Comparator<Good> comparator = new Comparator<Good>() {
			@Override
			public int compare(Good o1, Good o2) {
				if (o1.getCode().equals(o2.getCode())) {
					return 1;
				}
				return 0;
			}
		};
		goods.sort(comparator);
		return goods;
	}

	public String formatMoney(int price) {
		String finalPrice = "";
		double realPrice = (double) price / 100;
		DecimalFormat formater = new DecimalFormat("###.## UAH");
		finalPrice = formater.format(realPrice);
		return finalPrice;
	}
}
