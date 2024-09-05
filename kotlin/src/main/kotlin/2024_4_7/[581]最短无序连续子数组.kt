import kotlin.math.round

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
// 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1136 👎 0


fun main() {
    ShortestUnsortedContinuousSubarray.Solution().findUnsortedSubarray(intArrayOf(1, 3, 2, 3, 3))
}

class ShortestUnsortedContinuousSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findUnsortedSubarray(nums: IntArray): Int {
            var max = Int.MIN_VALUE
            var min = Int.MAX_VALUE
            var left=-1
            var right=-1
            nums.forEachIndexed { index, value ->
                if(max>value){
                    right=index
                }else{
                    max=value
                }

                if(min<nums[nums.size-1-index]){
                    left=nums.size-1-index
                }else{
                    min=nums[nums.size-1-index]
                }
            }
            return if(right==-1) 0 else right-left+1
        }

//    fun findUnsortedSubarray(nums: IntArray): Int {
//       var i= findRight(nums)-findLeft(nums)
//        return if(i==0) 0 else i+1
//    }
//
//        fun findLeft(nums: IntArray):Int{
//            var pre=0
//            for(index in 1 until nums.size){
//                if(nums[index-1]>nums[index]){
//                    pre=index
//                    break
//                }
//            }
//            if(pre==0) return -1
//            var min=Int.MAX_VALUE
//            for(index in pre until nums.size){
//                min=Math.min(min,nums[index])
//            }
//
//            pre=0
//            while (nums[pre]<=min){
//                pre++
//            }
//            return pre
//        }
//
//        fun findRight(nums: IntArray):Int{
//            var pre=nums.size-1
//            for(index in nums.size-2 downTo  0){
//                if(nums[index+1]<nums[index]){
//                    pre=index
//                    break
//                }
//            }
//            if(pre==nums.size-1) return -1
//            var max=Int.MIN_VALUE
//            for(index in pre downTo  0){
//                max=Math.max(max,nums[index])
//            }
//
//            pre=nums.size-1
//            while (nums[pre]>=max){
//                pre--
//            }
//            return pre
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}