package `2023-11-15`

import data.TreeNode

//给你两棵二叉树： root1 和 root2 。
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1351 👎 0

fun main() {
    ;
}

class MergeTwoBinaryTrees {
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
        fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            if (root1 == null && root2 == null) {
                return root1
            } else {
                var ans: TreeNode? = TreeNode(0)
                if (root1 != null && root2 != null) {
                    ans?.`val` = root1.`val` + root2.`val`
                    ans?.left = mergeTrees(root1.left, root2.left)
                    ans?.right = mergeTrees(root1.right, root2.right)
                } else if (root2 != null) {
                    ans = root2
                } else {
                    ans = root1
                }
                return ans
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}