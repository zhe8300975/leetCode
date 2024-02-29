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
// Related Topics 数组 回溯 👍 2816 👎 0

fun main() {

}

class Permutations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            var ans=ArrayList<List<Int>>()
            permute(nums, BooleanArray(nums.size), ArrayList(),ans)
            return ans
        }

        fun permute(nums: IntArray,dp:BooleanArray ,path: ArrayList<Int>, ans: ArrayList<List<Int>>) {
            if(nums.size==path.size){
                ans.add(ArrayList(path))
                return
            }
            for(i in 0 until dp.size){
                if(!dp[i]){
                    dp[i]=true
                    path.add(nums[i])
                    permute(nums,dp,path,ans)
                    path.removeAt(path.size-1 )
                    dp[i]=false
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
