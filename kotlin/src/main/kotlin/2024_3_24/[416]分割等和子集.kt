import java.util.PriorityQueue

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2038 👎 0


fun main(){
    PartitionEqualSubsetSum.Solution().canPartition(intArrayOf(1,2,5))
}
class PartitionEqualSubsetSum{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum=nums.sum()
        if(sum%2!=0||nums.size<2){
            return false
        }
        var target=sum/2
        var dp=Array<BooleanArray>(nums.size){ BooleanArray(target+1) }
        for(i in 0 until nums.size){
            dp[i][0]=true
        }
        if(nums[0]<=target) {
            dp[0][nums[0]] = true
        }else{
            return false
        }
        for(i in 1 until nums.size){
            var num=nums[i]
            for(j in 1 .. target){
                if(j>=num){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-num]
                }else{
                    dp[i][j]=dp[i-1][j]
                }
            }
        }
        return dp[nums.size - 1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}