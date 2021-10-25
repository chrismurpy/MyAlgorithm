//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 👍 4571 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        double a = findK(nums1, nums2, 0, 0, (n + 1) / 2);
        if (n % 2 != 0) return a;
        double b = findK(nums1, nums2, 0, 0, (n + 1) / 2 + 1);
        return (a + b) / 2;
    }

    public double findK(int[] nums1, int[] nums2, int k1, int k2, int k) {
        if (k1 == nums1.length) return nums2[k2 + k - 1];
        if (k2 == nums2.length) return nums1[k1 + k - 1];
        if (k == 1) return nums1[k1] < nums2[k2] ? nums1[k1] : nums2[k2];
        int a = Math.min(k / 2, nums1.length - k1);
        int b = Math.min(k - a, nums2.length - k2);
        a = k - b;
        if (nums1[k1 + a - 1] <= nums2[k2 + b - 1]) {
            return findK(nums1, nums2, k1 + a, k2, k - a);
        }
        return findK(nums1, nums2, k1, k2 + b, k - b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
