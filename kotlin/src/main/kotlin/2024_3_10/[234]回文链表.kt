import data.ListNode
import utlis.ListUtils

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
// Related Topics 栈 递归 链表 双指针 👍 1870 👎 0


fun main(){
    PalindromeLinkedList.Solution().isPalindrome(ListUtils.createListNode(intArrayOf(1,2,2,1)))
}
class PalindromeLinkedList{
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
        var fast:ListNode?=ListNode(-1).apply {
            this.next=head
        }
        var slow=fast
        while(fast?.next!=null){
            fast=fast?.next?.next
            slow=slow?.next
        }
        reset(slow)
        var list2=slow?.next
        var list1=head
        while(list2!=null){
            if(list1?.`val`!=list2.`val`){
                return false
            }
            list1=list1.next
            list2=list2.next
        }
        return true

    }


    fun reset(head: ListNode?){
        var pre=head?.next
        head?.next=null
        while(pre!=null){
            var node=pre
            pre=pre.next

            node.next=head?.next
            head?.next=node
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}