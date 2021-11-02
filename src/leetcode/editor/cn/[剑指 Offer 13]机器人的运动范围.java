//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 375 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0], y = xy[1];
            for (int i = 0; i < 2; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < m && newX >= 0 && newY < n && newY >= 0 && !visited[newX][newY] && get(newX) + get(newY) <= k) {
                    visited[newX][newY] = true;
                    ans ++;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return ans;
    }

    public int get(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
