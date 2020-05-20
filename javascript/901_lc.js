/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6]
*/
const StockSpanner = function () {
  this.prices = [];
  this.spans = [];
};

/**
 * @param {number} price
 * @return {number}
 */
StockSpanner.prototype.next = function (price) {
  const { prices, spans } = this;

  prices.push(price);

  if (prices.length === 1) {
    spans.push(1);
    return 1;
  }

  let priceIdx = prices.length - 1;
  let currIdx = prices.length - 2;

  while (currIdx >= 0 && prices[currIdx] <= price) {
    currIdx -= spans[currIdx];
  }

  spans[priceIdx] = priceIdx - currIdx;
  return spans[priceIdx];
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = new StockSpanner()
 * var param_1 = obj.next(price)
 */
