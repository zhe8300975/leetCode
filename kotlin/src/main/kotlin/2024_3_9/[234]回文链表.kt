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
// Related Topics 栈 递归 链表 双指针 👍 1868 👎 0


fun main(){
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
        var slow=head
        var fast=head?.next
        while(fast?.next!=null){
            fast=fast?.next?.next
            slow=slow?.next
        }
        var listHead=slow?.next
        slow?.next=null

        var list1Pre=head
        var list2Pre=reset(listHead)
        while(list2Pre!=null&&list1Pre!=null){
            if(list2Pre.`val`!=list1Pre.`val`){
                return false
            }
            list1Pre=list1Pre?.next
            list2Pre=list2Pre?.next
        }
        return true
    }
    fun reset(head: ListNode?):ListNode?{
        var myHead=ListNode(-1)
        var pre=head
        while(pre!=null){
            var node=pre
            pre=pre.next

            node.next=myHead.next
            myHead.next=node
        }
        return myHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}