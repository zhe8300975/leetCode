//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2441 👎 0


fun main() {
}

class NextPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun nextPermutation(nums: IntArray): Unit {
            var index = nums.size - 2
            while (index >= 0) {
                if (nums[index] >= nums[index + 1]) {
                    index--
                } else {
                    var i = index + 1
                    while (i < nums.size && nums[i] > nums[index]) {
                        i++
                    }
                    swipe(nums, i - 1, index)
                    revert(nums,index+1,nums.size-1)
                    return
                }
            }
            if (index==-1){
                revert(nums,0,nums.size-1)
            }
        }

        fun swipe(nums: IntArray, index1: Int, index2: Int) {
            var num = nums[index1]
            nums[index1] = nums[index2]
            nums[index2] = num
        }

        fun revert(nums: IntArray, start: Int, end: Int) {
            for(i in 0 .. (end-start)/2){
                swipe(nums,start+i,end-i)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}