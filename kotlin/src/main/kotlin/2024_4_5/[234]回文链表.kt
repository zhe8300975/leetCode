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
// Related Topics 栈 递归 链表 双指针 👍 1882 👎 0


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
        if(head?.next==null){
            return true
        }
        var fast=head.next
        var slow=head
        while(fast?.next!=null){
            fast=fast.next?.next
            slow=slow?.next
        }
        var pre=slow?.next
        while(pre?.next!=null){
            var node=pre.next

            pre.next=node?.next
            node?.next=slow?.next
            slow?.next=node
        }
        var pre1=head
        var pre2=slow?.next
        while(pre1!=null&&pre2!=null){
            if(pre1.`val`!=pre2.`val`){
                return false
            }
            pre1=pre1.next
            pre2=pre2.next
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}