# [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

## Problem Description

```
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

## Key Points

- Initialize `profit` to `0` to store the maximum profit and `buyTime` to the first day's price (`prices[0]`).
- Traverse the `prices` array starting from the second day (`i = 1`).
- If the current price (`prices[i]`) is greater than `buyTime`:
  - Calculate the profit as `prices[i] - buyTime`.
  - Update `profit` to the maximum of the current `profit` and the new profit.
- If the current price (`prices[i]`) is less than `buyTime`, update `buyTime` to the current price.

## Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        //Greedy Algorithm - 0(n)
        int profit = 0, buyTime = prices[0];
        for(int i = 1 ;i<prices.length;i++){
            //makes decisions based on what looks best at the moment
            if(prices[i]>buyTime) {
                profit = Math.max(profit,prices[i]-buyTime);
            }
            else buyTime = prices[i];
        }
        return profit;

        //brute force method - O(n^2)
        // int max = 0,cur;
        // for(int i = 0;i<prices.length-1;i++){
        //     int j = i+1;
        //     while(prices[i]<prices[j]){
        //         int curr = prices[j] - prices[i];
        //         if(max<curr) max = curr;
        //         j++;
        //         if(j>=prices.length) break;
        //     }
        // }
        // return max;
    }
}
```
**_Complexity Anlysis_**

- Achieves **O(N)** time complexity with a single pass
- **O(1)** space complexity.
