//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2652 👎 0


fun main() {
}

class FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            return intArrayOf(findLeft(nums, target), findRight(nums, target))
        }

        fun findLeft(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1
            while (left < right) {
                var mid = (left + right) / 2
                if (nums[mid] == target) {
                    right = mid
                } else if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return if (left >= 0 && left < nums.size && nums[left] == target) left else -1

        }

        fun findRight(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1
            while (left < right) {
                var mid = (left + right + 1) / 2
                if (nums[mid] == target) {
                    left = mid
                } else if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return if (left >= 0 && left < nums.size && nums[left] == target) left else -1

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}