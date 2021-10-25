//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 1866 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * word1: "abcde"
         * word2: "fgh"
         *
         * case 1: "abcd" -> "fgh" needs dp[i - 1][j] steps # 末位不相同，前i-1位变为j项，第一个数末位删除
         *         "abcde" -> "abcd" -> "fgh": total 1 + dp[i - 1][j] steps
         * case 2: "abcde" -> "fg" needs dp[i][j - 1] steps # 末位不相同，前i项变为j-1项，第二个数末位添加
         *         "abcde" -> "fg" -> "fgh": total dp[i][j - 1] + 1 steps
         * case 3: "abcd" -> "fg" needs dp[i - 1][j - 1] steps # 末位不相同，前i-1变为j-1项，最后一项作替换操作
         *         "abcde" -> "fge" -> "fgh": total 1 + dp[i - 1][j - 1]  steps
         * case 4: "abcdg" -> "fgg": total dp[i - 1][j - 1] steps # 末位相等 - 前i-1项变为j-1项
         */
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
