//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 525 👎 0


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

    List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        for(int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if(root == null) return;
        if(res.size() == k) res.add(new ArrayList<>());
        res.get(k).add(root.val);
        dfs(root.left, k + 1);
        dfs(root.right, k + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
