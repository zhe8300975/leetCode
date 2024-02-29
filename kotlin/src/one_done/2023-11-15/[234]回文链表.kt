package `2023-11-15`

import data.ListNode

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1817 👎 0

fun main() {
    ;
}

class PalindromeLinkedList {
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
        fun isPalindrome(head: ListNode?): Boolean {
            if (head == null || head.next == null) {
                return true
            }

            var minddleNode = findMiddle(head)
            var second = revers(minddleNode)
            var slow: ListNode? = head
            var fast: ListNode? = second
            while (fast != null && slow != null) {
                if (fast.`val` != slow.`val`) {
                    return false
                }
                fast = fast?.next
                slow = slow?.next
            }
            return true


        }

        //加头和不加头区别  加头相比不加头的快指针 多走一个
        //也就是在不加头fastNode!=null的区情况下 加头的fastNode==null
        // 奇数个情况下 fastNode==null 不加头 slowNode指的是中间的下一个  加头的fastNode是中间的那个
        fun findMiddle(head: ListNode?): ListNode {
            val head = ListNode(-1).apply {
                this.next = head
            }
            var slow: ListNode? = head
            var fast: ListNode? = head
            while (fast != null) {
                slow = slow?.next
                fast = fast?.next?.next
            }
            return slow!!
        }

        fun revers(head: ListNode): ListNode {
            val ans = ListNode(-1)
            var pre: ListNode? = head
            while (pre != null) {
                val node = pre
                pre = pre.next
                node.next = ans.next
                ans.next = node
            }
            return ans.next!!
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}