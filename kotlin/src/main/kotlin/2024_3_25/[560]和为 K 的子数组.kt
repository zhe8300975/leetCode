//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2289 👎 0


fun main() {
}

class SubarraySumEqualsK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subarraySum(nums: IntArray, k: Int): Int {
           var map=HashMap<Int,Int>().apply { this.put(0,1) }
            var ans=0
            var sum=0
            nums.forEach { value->
                sum+=value
                ans+=map.getOrDefault(sum-k,0)
                map.put(sum,map.getOrDefault(sum,0)+1)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}