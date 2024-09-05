//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
// 并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2199 👎 0


fun main() {
    MaximumProductSubarray.Solution().maxProduct(intArrayOf(2, 3, -2, 4))
}

class MaximumProductSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProduct(nums: IntArray): Int {
            var dpMax = IntArray(nums.size)
            var dpMin = IntArray(nums.size)
            var ans = Int.MIN_VALUE
            nums.forEachIndexed { index, value ->
                if (index == 0) {
                    dpMax[0] = value
                    dpMin[0] = value
                } else {
                    dpMax[index] = Math.max(value, Math.max(value * dpMax[index - 1], value * dpMin[index - 1]))
                    dpMin[index] = Math.min(value, Math.min(value * dpMax[index - 1], value * dpMin[index - 1]))
                }
                ans = Math.max(ans, dpMax[index])
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}