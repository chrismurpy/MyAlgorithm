//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1526 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        // dp[i] - 能够凑成 i 金额的最少硬币数量
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // 如果需要组成的金额正好和某个硬币的面额相等
                if (coin == i) {
                    dp[i] = 1;
                } else {
                    // 只有先凑成 dp[i - coin] 才能凑成 dp[i]
                    if (dp[i - coin] != 0) {
                        if (dp[i] == 0) {
                            // 能凑成 dp[i - coin]，但不能凑成 dp[i]，那么直接将 dp[i - coin] + 1
                            dp[i] = dp[i - coin] + 1;
                        } else {
                            // 既能凑成 dp[i - coin]，又能凑成 dp[i]，那么取二者最小值
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
