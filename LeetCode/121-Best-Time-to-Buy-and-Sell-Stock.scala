object Solution {
    def maxProfit(prices: Array[Int]): Int = {
      // an array of integers is passed in and a Int is expected as a return value

      // [1,3,0,7,3,9,5] -> 9

      // Plan: iterate over prices and keep track of the current minimum stock price and max profit. Update max profit if necessary.

      // Psuedocode:
      // if prices length is less than 2
        // return 0
      // else
        // create mutable map with currentMin set to first array value and maxProfit set to 0

        // iterate over prices starting at the second price
          // if price is less than currentMin in map
            // set currentMin to price
          // if profit with price is greater than maxProfit in map
            // set maxProfit to profit with price

        // return maxProfit from map

      if (prices.length <= 1) {
        0
      } else {
        val minimumAndProfit = scala.collection.mutable.Map("currentMin" -> prices(0), "maxProfit" -> 0)

        for (i <- 0 until prices.length) {
          if (prices(i) < minimumAndProfit("currentMin")) {
            minimumAndProfit("currentMin") = prices(i)
          }
          if (prices(i) - minimumAndProfit("currentMin") > minimumAndProfit("maxProfit")) {
            minimumAndProfit("maxProfit") = prices(i) - minimumAndProfit("currentMin")
          }
        }

        minimumAndProfit("maxProfit")
      }
        
    }
}
