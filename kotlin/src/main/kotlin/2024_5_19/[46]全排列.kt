//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2875 👎 0


fun main() {
}

class Permutations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            var ans=ArrayList<ArrayList<Int>>()
            permute(nums, BooleanArray(nums.size),ArrayList<Int>(),ans)
            return ans
        }

        fun permute(nums: IntArray, used: BooleanArray, path: ArrayList<Int>, ans: ArrayList<ArrayList<Int>>) {
            if (path.size == nums.size) {
                ans.add(ArrayList(path))
                return
            }
            nums.forEachIndexed { index, value ->
                if (!used[index]) {
                    path.add(value)
                    used[index] = true
                    permute(nums,used,path,ans)
                    used[index] = false
                    path.removeAt(path.size - 1)
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}