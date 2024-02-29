package one_done.`1`//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2205 👎 0

fun main() {
    Subsets.Solution().subsets(intArrayOf(1,2,3))
}

class Subsets {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subsets(nums: IntArray): List<List<Int>> {
            var sum = 1 shl nums.size
            val ans = ArrayList<List<Int>>()
            for (i in 0 until  sum) {
                val list = ArrayList<Int>()
                for (n in 0 until nums.size) {
                    var bitNum = 1 shl n
                    if (bitNum and i == bitNum) {
                        list.add(nums[n])
                    }
                }
                ans.add(list)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
