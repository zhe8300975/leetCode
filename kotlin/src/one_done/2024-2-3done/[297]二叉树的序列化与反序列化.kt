package one_done.`2024-2-3done`

import data.ListNode
import data.TreeNode
import java.util.LinkedList

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1196 👎 0

fun main() {
    var node = SerializeAndDeserializeBinaryTree.Codec().deserialize("")
    SerializeAndDeserializeBinaryTree.Codec().serialize(node)
}

class SerializeAndDeserializeBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */

    class Codec() {

        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            if(root==null){
                return ""
            }
            var ans = ArrayList<String>()
            var queue = LinkedList<TreeNode?>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                var node = queue.removeFirst()
                node?.let {
                    ans.add(it.`val`.toString())
                    queue.add(it.left)
                    queue.add(it.right)
                } ?: run {
                    ans.add("null")
                }
            }
            return ans.joinToString(",")
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            if(data.isEmpty()){
                return null
            }
            var list = data.split(",")
            var ans = TreeNode(list[0].toInt())
            var queue = LinkedList<TreeNode>()
            queue.add(ans)
            for (i in 1 until list.size step 2) {
                var node = queue.removeFirst()
                list.getOrNull(i)?.takeIf { !"null".equals(it) }?.let {
                    node.left = TreeNode(it.toInt()).apply { queue.add(this) }

                }
                list.getOrNull(i + 1)?.takeIf { !"null".equals(it) }?.let {
                    node.right = TreeNode(it.toInt()).apply { queue.add(this) }
                }
            }
            return ans
        }
    }

    /**
     * Your Codec object will be instantiated and called as such:
     * var ser = Codec()
     * var deser = Codec()
     * var data = ser.serialize(longUrl)
     * var ans = deser.deserialize(data)
     */
//leetcode submit region end(Prohibit modification and deletion)

}
