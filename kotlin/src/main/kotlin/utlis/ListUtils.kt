package utlis

import data.ListNode

object ListUtils {

    fun createListNode(intArray: IntArray): ListNode {
        val ans = ListNode(-1)
        var pre: ListNode = ans
        for (item in intArray) {
            pre.next = ListNode(item)
            pre = pre.next!!
        }
        return ans.next!!
    }

    fun printListNode(node: ListNode?) {
        if (node == null) {
            return
        }
        var nodeForPrint: ListNode? = node
        while (nodeForPrint != null) {
            print(nodeForPrint.`val`)
            print(",")
            nodeForPrint = nodeForPrint.next
        }
    }
}