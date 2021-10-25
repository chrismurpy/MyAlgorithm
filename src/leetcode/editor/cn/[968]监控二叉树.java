//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        int[][] dp = new int[2][2];
        getDp(root, dp);
        return Math.min(dp[0][0], dp[0][1]);
    }

    public void getDp(TreeNode root, int[][] dp) {
        if (root == null) {
            dp[0][0] = 0;
            dp[0][1] = 10000;
            dp[1][0] = 0;
            dp[1][1] = 10000;
            return;
        }
        if (root.left == null && root.right == null) {
            dp[0][0] = 10000;
            dp[0][1] = 1;
            dp[1][0] = 0;
            dp[1][1] = 1;
            return;
        }
        int[][] l = new int[2][2];
        int[][] r = new int[2][2];
        getDp(root.left, l);
        getDp(root.right, r);
        dp[0][0] = Math.min(Math.min(l[0][1] + r[0][0], l[0][0] + r[0][1]), l[0][1] + r[0][1]);
        dp[0][1] = Math.min(Math.min(l[1][0] + r[1][0], l[1][1] + r[1][1]), Math.min(l[1][1] + r[1][0], l[1][0] + r[1][1])) + 1;
        dp[1][0] = Math.min(dp[0][0], l[0][0] + r[0][0]);
        dp[1][1] = dp[0][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
