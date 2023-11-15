import data.ListNode

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3351 👎 0

fun main() {
    ;
}

class MergeTwoSortedLists {
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            val ans = ListNode(-1)
            var list1Pre: ListNode? = list1
            var list2Pre: ListNode? = list2
            var pre = ans
            while (list1Pre != null || list2Pre != null) {
                if (list1Pre != null && list2Pre != null) {
                    if (list1Pre.`val` <= list2Pre.`val`) {
                        pre.next = list1Pre
                        list1Pre = list1Pre.next
                    } else {
                        pre.next = list2Pre
                        list2Pre = list2Pre.next
                    }
                    pre = pre.next!!
                } else if (list1Pre != null) {
                    pre.next = list1Pre
                    break
                } else {
                    pre.next = list2Pre
                    break
                }
            }
            return ans.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}