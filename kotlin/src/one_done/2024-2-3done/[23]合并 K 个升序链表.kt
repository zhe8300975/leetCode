package one_done.`2024-2-3done`

import data.ListNode

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2732 👎 0

fun main() {
    
}
class MergeKSortedLists{
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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return mergeKLists(lists,0,lists.size-1)
    }

    fun mergeKLists(lists: Array<ListNode?>,left:Int,right:Int): ListNode? {
        if(left==right){
            return lists[left]
        }
        val mid=(left+right)/2
        return mergeList(mergeKLists(lists,left,mid),mergeKLists(lists,mid+1,right))
    }


    fun mergeList(listNode1:ListNode?,listNode2:ListNode?):ListNode?{
        var ans=ListNode(-1)
        var pre=ans
        var list1=listNode1
        var list2=listNode2
        while(list1!=null||list2!=null){
            if(list1!=null&&list2!=null){
                if(list1.`val`<=list2.`val`){
                    pre.next=list1
                    list1=list1.next
                }else{
                    pre.next=list2
                    list2=list2.next
                }
                pre=pre.next!!
            }else if(list1!=null){
                pre.next=list1
                break
            }else{
                pre.next=list2
                break
            }
        }
        return ans.next

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
