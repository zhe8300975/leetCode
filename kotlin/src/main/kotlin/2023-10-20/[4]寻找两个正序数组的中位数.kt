//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6834 👎 0

fun main() {

    print(MedianOfTwoSortedArrays.Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
}


class MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            //左小  右大

            if (nums1.size > nums2.size) {
                return findMedianSortedArrays(nums2, nums1)
            }
            var left = 0
            var right = nums1.size
            while (left <= right) {
                val i = (left + right) / 2
                val j = (nums1.size + nums2.size + 1) / 2 - i
                if (j != 0 && i != nums1.size && nums2[j - 1] > nums1[i]) {
                    left = i + 1
                } else if (i != 0 && j != nums2.size && nums1[i - 1] > nums2[j]) {
                    right = i - 1
                } else {
                    var maxLeft = 0
                    if (i == 0) {
                        maxLeft = nums2[j - 1]
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1]
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1])
                    }

                    if ((nums1.size + nums2.size) % 2 == 1) return maxLeft.toDouble()

                    var minRight = 0
                    if (i == nums1.size) {
                        minRight = nums2[j]
                    } else if (j == nums2.size) {
                        minRight = nums1[i]
                    } else {
                        minRight = Math.min(nums1[i], nums2[j])
                    }

                    return (maxLeft + minRight).toDouble() / 2
                }
            }

            return 0.0


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}