//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
//
// Related Topics 数组 哈希表 👍 1307 👎 0


fun main(){
}
class FindAllNumbersDisappearedInAnArray{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        nums.forEach {
            var index=Math.abs(it)
            if(nums[index-1]>0){
                nums[index-1]*=-1
            }
        }
        var ans =ArrayList<Int>()
        for(i in 0.. nums.size-1){
            if(nums[i]>0){
                ans.add(i+1)
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}