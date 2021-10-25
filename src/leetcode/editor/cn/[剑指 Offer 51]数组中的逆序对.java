//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 536 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        return merge_sort(nums, 0, nums.length - 1);
    }

    public int merge_sort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + ((r - l) >> 1), ans = 0;
        ans += merge_sort(nums, l, mid);
        ans += merge_sort(nums,mid + 1, r);
        int[] temp = new int[r - l + 1];
        // 定义临时指针
        int k = 0, p1 = l, p2 = mid + 1;
        while (p1 <= mid || p2 <= r) {
            // p2遍历结束 - p1继续
            if ((p2 > r) || (p1 <= mid && nums[p1] <= nums[p2])) {
                temp[k++] = nums[p1++];
            } else {
                temp[k++] = nums[p2++];
                ans += (mid - p1 + 1);
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i + l] = temp[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
