//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 224 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (priorityQueue.size() < k || (nums1[i] + nums2[j] < priorityQueue.peek()[2])) {
                    priorityQueue.offer(new int[]{nums1[i], nums2[j], nums1[i] + nums2[j]});
                    if (priorityQueue.size() > k) priorityQueue.poll();
                } else break;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int[] num = priorityQueue.poll();
            result.add(new ArrayList<Integer>() {{
                this.add(num[0]);
                this.add(num[1]);
            }});
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
