

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
// Related Topics 递归 链表 👍 3434 👎 0

fun main() {
    
}
class MergeTwoSortedLists{
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
        var ans =ListNode(-1)
        var pre=ans
        var l1=list1
        var l2=list2
        while(l1!=null&&l2!=null){
            if(l1.`val`<=l2.`val`){
                pre.next=l1
                l1=l1.next
            }else{
                pre.next=l2
                l2=l2.next
            }
            pre=pre.next!!
        }
        if(l1!=null){
            pre.next=l1
        }
        if(l2!=null){
            pre.next=l2
        }
        return ans.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
