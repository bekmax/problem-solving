package leetcode.slidingwindow;


/**
 * N121 Best Time To Buy And Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class EasyBestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 4, 5, 6};

        System.out.println(solution.maxProfitOptimized(prices));
    }

    static class Solution {
        public int maxProfitOptimized(int[] prices) {
            int min = prices[0];
            int profit = 0;

            for(int p : prices){
                if(min > p){
                    min = p;
                }
                else{
                    profit = (int)Math.max(p-min, profit);
                }
            }
            return profit;
        }
    }
}

