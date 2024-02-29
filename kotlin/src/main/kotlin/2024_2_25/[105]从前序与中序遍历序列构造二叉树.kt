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
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2246 👎 0

fun main() {

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
            return buildTree(inorder, preorder, 0, inorder.size - 1, 0, preorder.size - 1)
        }

        fun buildTree(
            inorder: IntArray,
            preorder: IntArray,
            inorderStart: Int,
            inorderEnd: Int,
            preorderStart: Int,
            preorderEnd: Int
        ): TreeNode? {
            var value = preorder[preorderStart]
            var node = TreeNode(value)
            if (preorderStart != preorderEnd) {
                var pre = inorderStart
                while (inorder[pre] != value) {
                    pre++
                }
                var leftNum = pre - inorderStart
                var rightNum = inorderEnd - pre
                if (leftNum > 0) {
                    node.left = buildTree(
                        inorder,
                        preorder,
                        inorderStart,
                        inorderStart + leftNum - 1,
                        preorderStart + 1,
                        preorderStart + leftNum
                    )
                }
                if (rightNum > 0) {
                    node.right = buildTree(
                        inorder,
                        preorder,
                        inorderStart + leftNum + 1,
                        inorderEnd,
                        preorderStart + leftNum + 1,
                        preorderEnd
                    )
                }

            }
            return node

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
