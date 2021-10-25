//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 数组 字符串 动态规划 👍 565 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j][k] - 前i个字符串中用j个0和k个1构成的最大的字符串个数
        // strs[i] contains zeros 0 and ones 1
        // dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1)
        int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1];
        // 循环 i，对应数组的每个数
        for (int i = 0; i <=l; i++) {
            int[] bits = new int[]{0, 0};
            if (i > 0) {
                bits = countBits(strs[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j >= bits[0] && k >= bits[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - bits[0]][k - bits[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    // count 0's and 1's
    private int[] countBits(String num) {
        int[] bits = new int[2];
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                bits[0] ++;
            } else {
                bits[1] ++;
            }
        }
        return bits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
