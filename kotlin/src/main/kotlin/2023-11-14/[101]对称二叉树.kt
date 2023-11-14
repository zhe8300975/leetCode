import data.TreeNode

//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2588 👎 0

fun main() {
    ;
}

class SymmetricTree {
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
        fun isSymmetric(root: TreeNode?): Boolean {
            return isSymmetric(root?.left, root?.right)
        }

        fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
            if (left == null || right == null) {
                return left?.`val` == right?.`val`
            } else if (left?.`val` == right?.`val`) {
                return isSymmetric(left?.left, right?.right) && isSymmetric(left?.right, right?.left)
            }
            return false
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}