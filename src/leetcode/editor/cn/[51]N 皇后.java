//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 数组 回溯 👍 1065 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] x = new int[9];
    int[] y = new int[18];
    int[] z = new int[18];

    public List<List<String>> solveNQueens(int n) {
        char[][] mp = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mp[i],'.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, n, mp, res);
        return res;
    }

    public void dfs(int index, int n, char[][] mp, List<List<String>> res) {
        if (index == n) {
            res.add(construct(mp));
            return;
        }
        for (int i = 0; i < n; i++) {
            int ind1 = i + index;
            int ind2 = n - 1 - i + index;
            if (x[i] == 1 || y[ind1] == 1 || z[ind2] == 1) continue;
            x[i] = y[ind1] = z[ind2] = 1;
            mp[index][i] = 'Q';
            dfs(index + 1, n, mp, res);
            x[i] = y[ind1] = z[ind2] = 0;
            mp[index][i] = '.';
        }
    }

    public List<String> construct(char[][] mp) {
        List<String> path = new ArrayList<>();
        for (char[] chars : mp) {
            path.add(new String(chars));
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
