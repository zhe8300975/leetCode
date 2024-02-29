package one_done.`1`//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6494 👎 0

fun main() {
    
}
class MaximumSubarray{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp=IntArray(nums.size){0}
        var ans=nums[0]
        nums.forEachIndexed{index,value->
            if(index==0){
                dp[index]=value
            }else{
                dp[index]=if(dp[index-1]>=0) dp[index-1]+value else value
            }
            ans=Math.max(ans,dp[index])
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
