package one_done.`1`

import data.TreeNode

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2161 👎 0

fun main() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal.Solution().buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
}

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            return buildTree(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
        }

        fun buildTree(
            preorder: IntArray,
            preorderStrat: Int,
            preorderEnd: Int,
            inorder: IntArray,
            inorderStart: Int,
            inorderEnd: Int
        ): TreeNode? {
            if (preorderStrat > preorderEnd || inorderStart > inorderEnd) {
                return null
            }
            val nodeVal = preorder[preorderStrat]
            val node = TreeNode(nodeVal)
            if (preorderStrat != preorderEnd) {
                for (index in inorderStart..inorderEnd) {
                    if (inorder[index] == nodeVal) {
                        node.left = buildTree(
                            preorder,
                            preorderStrat + 1,
                            preorderStrat + index - inorderStart,
                            inorder,
                            inorderStart,
                            index - 1
                        )
                        node.right = buildTree(
                            preorder,
                            preorderStrat + index - inorderStart + 1,
                            preorderEnd,
                            inorder,
                            index + 1,
                            inorderEnd
                        )
                        break
                    }
                }
            }
            return node

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
