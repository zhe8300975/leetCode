import data.ListNode

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2732 👎 0

fun main() {
    ;
}

class RemoveNthNodeFromEndOfList {
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
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val ans = ListNode(-1)
            ans.next = head
            var slow: ListNode? = ans
            var fast: ListNode? = ans
            for (index in 1..n) {
                fast = fast?.next
            }
            while (fast != null && fast.next != null) {
                slow = slow?.next
                fast = fast?.next
            }
            slow?.next = slow?.next?.next
            return ans.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}