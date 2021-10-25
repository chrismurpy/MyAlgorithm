//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 588 👎 0


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

    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root != null) {
            dfs("", root);
        }
        return res;
    }

    public void dfs(String path, TreeNode root) {
        String value = String.valueOf(root.val);
        path = path.length() == 0 ? value : path + "->" + value;

        if(root.left == null && root.right == null) {
            res.add(path);
            return;
        } else {
            if(root.left != null) {
                dfs(path, root.left);
            }
            if(root.right != null) {
                dfs(path, root.right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
