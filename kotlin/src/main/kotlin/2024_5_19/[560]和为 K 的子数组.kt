//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2339 👎 0


fun main() {
    SubarraySumEqualsK.Solution().subarraySum(intArrayOf(1,1,1),2)
}

class SubarraySumEqualsK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subarraySum(nums: IntArray, k: Int): Int {
            var dp = IntArray(nums.size + 1)
            var sum = 0
            nums.forEachIndexed { index, value ->
                sum += value
                dp[index + 1] = sum
            }
            sum = 0
            for (end in 1..nums.size) {
                for (start in 0 until end) {
                    if (k == dp[end] - dp[start]){
                        sum++
                    }
                }
            }
            return sum
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}