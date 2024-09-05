//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数 1 的气球。
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1335 👎 0


fun main() {
    BurstBalloons.Solution().maxCoins(intArrayOf(3, 1, 5, 8))
}

class BurstBalloons {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxCoins(nums: IntArray): Int {
            var newNums = IntArray(nums.size + 2) { 1 }
            nums.forEachIndexed { index, i -> newNums[index + 1] = i }
            var dp = Array(nums.size + 2) { IntArray(nums.size+2) }
            for (i in nums.size + 2 - 2 - 1 downTo 0) {
                for (j in i + 2 until nums.size + 2) {
                    for (k in i + 1..j - 1) {
                        var sum = newNums[i] * newNums[k] * newNums[j]
                        sum += (dp[i][k] + dp[k][j])
                        dp[i][j] = Math.max(dp[i][j], sum)
                    }
                }
            }
            return dp[0][nums.size + 1]
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}