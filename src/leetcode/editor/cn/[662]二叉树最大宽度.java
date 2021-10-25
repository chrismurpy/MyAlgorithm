//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 260 👎 0


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

    class PNI {
        TreeNode root;
        int n;

        public PNI(TreeNode root, int n) {
            this.root = root;
            this.n = n;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<PNI> queue = new ArrayDeque<>();
        // 存根节点
        queue.offer(new PNI(root,0));
        // 记录最大宽度
        int ans = 0;
        // 层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 第一个出队的最左侧节点
            int l = queue.peek().n;
            // 将要拿到的每个节点的编号
            int r = 0;
            for (int i = 0; i < size; i++) {
                PNI temp = queue.poll();
                r = temp.n - l;
                if (temp.root.left != null) {
                    queue.offer(new PNI(temp.root.left,r * 2));
                }
                if (temp.root.right != null) {
                    queue.offer(new PNI(temp.root.right,r * 2 + 1));
                }
            }
            ans = ans > r + 1 ? ans : r + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
