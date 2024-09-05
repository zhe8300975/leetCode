import data.ListNode

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
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
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2285 👎 0


fun main(){
}
class SortList{
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
    fun sortList(head: ListNode?): ListNode? {
        if(head?.next==null){
            return head
        }
        var fast=head.next
        var slow=head
        while(fast?.next?.next!=null){
            fast=fast.next?.next
            slow=slow?.next
        }
        var lastHead=slow?.next
        slow?.next=null
        return merge(sortList(head),sortList(lastHead))
    }

    fun merge(list1:ListNode?,list2:ListNode?):ListNode?{
        var head=ListNode(-1)
        var pre:ListNode?=head
        var pre1=list1
        var pre2=list2
        while(pre1!=null&&pre2!=null){
            if(pre1.`val`<=pre2.`val`){
                pre?.next=pre1
                pre1=pre1.next
            }else{
                pre?.next=pre2
                pre2=pre2.next
            }
            pre=pre?.next
        }
        pre1?.let { pre?.next=it }
        pre2?.let { pre?.next=it }
        return head.next

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}