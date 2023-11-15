import java.util.Arrays

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2225 👎 0

fun main() {
    var list = intArrayOf(0, 1, 0, 3, 12)
    MoveZeroes.Solution().moveZeroes(list)
    print(list.contentToString())
}

class MoveZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var zeroIndex = -1
            for (index in nums.indices) {
                if (nums[index] == 0 && zeroIndex == -1) {
                    zeroIndex = index
                } else if (nums[index] != 0 && zeroIndex != -1) {
                    nums[zeroIndex] = nums[index]
                    nums[index] = 0
                    zeroIndex++
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}