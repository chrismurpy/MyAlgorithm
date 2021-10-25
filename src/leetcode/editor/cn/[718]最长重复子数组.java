//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 554 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] : A[i:] & B[j:] 的最长公共前缀
        // max(dp[i][j])
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    /**
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     *
     * i = 4, j = 2
     * A[4:] = [1]
     * B[j:] = [1,4,7]
     * dp[4][2] = "1"
     *
     * if A[i] != B[j] -> dp[i][j] = 0
     * else dp[i][j] = dp[i+1][j+1] + 1
     */
}
//leetcode submit region end(Prohibit modification and deletion)
