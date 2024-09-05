import data.TreeNode

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1961 👎 0


fun main() {

}

class HouseRobberIii {
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
        fun rob(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            var dp_done = HashMap<TreeNode, Int>()
            var dp_none = HashMap<TreeNode, Int>()
            rob(root, dp_done, dp_none)
            return Math.max(dp_done.getOrDefault(root, 0), dp_none.getOrDefault(root, 0))
        }

        fun rob(root: TreeNode, dp_done: HashMap<TreeNode, Int>, dp_none: HashMap<TreeNode, Int>) {
            if (root.left == null && root.right == null) {
                dp_done.put(root, root.`val`)
                dp_none.put(root, 0)
                return
            }
            root.left?.let {
                rob(it, dp_done, dp_none)
            }
            root.right?.let {
                rob(it, dp_done, dp_none)
            }

            dp_done.put(root, root.`val` + dp_none.getOrDefault(root.left, 0)+dp_none.getOrDefault(root.right, 0))
            dp_none.put(root, Math.max(dp_none.getOrDefault(root.left, 0), dp_done.getOrDefault(root.left, 0))
                    +Math.max(dp_none.getOrDefault(root.right, 0), dp_done.getOrDefault(root.right, 0)))

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}