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
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1139 👎 0


fun main() {
}

class ShortestUnsortedContinuousSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findUnsortedSubarray(nums: IntArray): Int {
            return if (getRight(nums) == -1) 0 else (getRight(nums) - getLeft(nums) + 1)
        }

        fun getLeft(nums: IntArray): Int {
            var min = Int.MAX_VALUE
            for (i in 1 until nums.size) {
                if (min == Int.MAX_VALUE) {
                    if (nums[i] < nums[i - 1]) {
                        min = nums[i]
                    }
                } else {
                    min = Math.min(min, nums[i])
                }
            }
            if (min == Int.MAX_VALUE) {
                return -1
            }
            nums.forEachIndexed { index, value ->
                if (value > min) {
                    return index
                }
            }
            return -1

        }

        fun getRight(nums: IntArray): Int {
            var max = Int.MIN_VALUE
            for (i in nums.size - 2 downTo 0) {
                if (max == Int.MIN_VALUE) {
                    if (nums[i] > nums[i + 1]) {
                        max = nums[i]
                    }
                } else {
                    max = Math.max(max, nums[i])
                }
            }
            if (max == Int.MIN_VALUE) {
                return -1
            }
            for (i in nums.size - 1 downTo 0) {
                if (max > nums[i]) {
                    return i
                }
            }
            return -1

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}