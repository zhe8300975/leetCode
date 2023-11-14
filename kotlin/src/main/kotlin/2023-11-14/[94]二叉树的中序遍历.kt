import data.TreeNode

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1967 👎 0

fun main() {
    ;
}

class BinaryTreeInorderTraversal {
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
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val ans = ArrayList<Int>()
            inorderTraversal(root, ans)
            return ans
        }

        fun inorderTraversal(root: TreeNode?, ans: ArrayList<Int>) {
            root?.let {
                inorderTraversal(root.left, ans)
                ans.add(it.`val`)
                inorderTraversal(root.right, ans)

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}