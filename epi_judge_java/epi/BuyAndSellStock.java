package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;

public class BuyAndSellStock {

  /**
   * Returns the maximum profit that could be made by buying
   * and then selling one share of stock
   * @param prices List of stock prices
   * @return       Maximum possible profit
   */
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    double maxProfit = Double.MIN_VALUE;
    double currentMin = Double.MAX_VALUE;

    // Iterate over the given list
    for (Double price: prices) {
      // Check if a better profit is possible
      currentMin = Math.min(currentMin, price);
      maxProfit = Math.max(maxProfit, price - currentMin);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
