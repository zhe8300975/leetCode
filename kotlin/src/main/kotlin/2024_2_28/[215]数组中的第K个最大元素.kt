import java.util.PriorityQueue

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2413 👎 0

fun main() {
    
}
class KthLargestElementInAnArray{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return findKthLargest(nums,0,nums.size-1,k)
    }
        fun findKthLargest(nums: IntArray,start:Int,end:Int,k: Int):Int{
            var pre=start
            var num=nums[end]
            for( index in start ..end){
                if(nums[index]<num){
                    swipe(nums,pre++,index)
                }
            }
            swipe(nums,pre,end)
            if(pre==nums.size-k){
                return num
            }else if(pre>nums.size-k){
                return findKthLargest(nums,start,pre-1,k)
            }else{
                return findKthLargest(nums,pre+1,end,k)
            }

        }
        fun swipe(nums: IntArray,start:Int,end:Int){
            var num = nums[start]
            nums[start]=nums[end]
            nums[end]=num

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
