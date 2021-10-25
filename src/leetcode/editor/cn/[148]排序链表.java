//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1335 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        return merge_sort(head, n);
    }

    public ListNode merge_sort(ListNode head, int n) {
        if (n <= 1) return head;
        // 左右链表的长度
        int l_cnt = n >> 1, r_cnt = n - l_cnt;
        // 伪头结点
        ListNode ret = new ListNode(-1), l = head, r = l, p = l;
        for (int i = 0; i < l_cnt - 1; i++) {
            p = p.next;
        }
        r = p.next;
        p.next = null;
        l = merge_sort(l, l_cnt);
        r = merge_sort(r, r_cnt);
        p = ret;
        while (l != null || r != null) {
            if (r == null || (l != null && l.val <= r.val)) {
                p.next = l;
                p = l;
                l = l.next;
            } else {
                p.next = r;
                p = r;
                r = r.next;
            }
        }
        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
