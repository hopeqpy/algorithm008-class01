/**
 * @program: algorithm
 * @description: 最大利润
 * @author: qpy
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null && prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit = prices[i] - prices[i--] + maxProfit;
            }
        }
        return maxProfit;
    }
}
