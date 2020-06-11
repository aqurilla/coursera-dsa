package epi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class BuyAndSellStockTwice {
	@EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
	public static double buyAndSellStockTwice(List<Double> prices) {

		List<Double> F = new ArrayList<Double>(Collections.nCopies(prices.size(), 0.0));
		List<Double> B = new ArrayList<Double>(Collections.nCopies(prices.size(), 0.0));

		// Find max profits for forward iteration
		double currentMin = prices.get(0);
		double currentMaxProfit = 0.0;

		for (int i = 0; i < prices.size(); i++) {
			currentMin = Math.min(currentMin, prices.get(i));
			currentMaxProfit = Math.max(currentMaxProfit, prices.get(i) - currentMin);
			F.add(i, currentMaxProfit);
		}

		// Find max profits for reverse iteration
		double currentMax = prices.get(prices.size() - 1);
		currentMaxProfit = 0;

		for (int i = prices.size() - 1; i >= 0; i--) {
			currentMax = Math.max(currentMax, prices.get(i));
			currentMaxProfit = Math.max(currentMaxProfit, currentMax - prices.get(i));
			B.set(i, currentMaxProfit);
		}

		// Calculate max profit considering both iterations
		double maxTotalProfit = B.get(0);

		for (int i = 1; i < B.size(); i++) {
			maxTotalProfit = Math.max(maxTotalProfit, B.get(i) + F.get(i - 1));
		}

		return maxTotalProfit;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "BuyAndSellStockTwice.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
