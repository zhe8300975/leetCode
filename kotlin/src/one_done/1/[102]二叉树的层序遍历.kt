package one_done.`1`

import data.TreeNode
import java.util.LinkedList

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1851 👎 0

fun main() {
    
}
class BinaryTreeLevelOrderTraversal{
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans=ArrayList<List<Int>>()
        val stack=LinkedList<TreeNode>()
        root?.let{
            stack.add(root)
        }
        while (!stack.isEmpty()){
            val size=stack.size
            val list=ArrayList<Int>()
            for(i in 1.. size){
                val node =stack.removeFirst()
                list.add(node.`val`)
                node.left?.let { stack.addLast(it) }
                node.right?.let{stack.addLast(it)}
            }
            ans.add(list)
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
