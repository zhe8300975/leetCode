package one_done.`2024-2-3done`

import java.util.PriorityQueue

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2675 👎 0

fun main() {
    SlidingWindowMaximum.Solution().maxSlidingWindow(intArrayOf(1,-1),1)
}
class SlidingWindowMaximum{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var n=nums.size
        var pq=PriorityQueue<IntArray>(Comparator { o1, o2 ->
            if(o1[0]!=o2[0]){
                return@Comparator o2[0]-o1[0]
            }else{
                return@Comparator o1[1]-o2[1]
            } })
        for(index in 0 until k){
            pq.offer(intArrayOf(nums[index],index))
        }
        var ans=IntArray(n-k+1)
        ans[0]=pq.peek()[0]
        for(index in k until n){
            pq.offer(intArrayOf(nums[index],index))
            while(pq.peek()[1]<=index-k){
                pq.poll()
            }
            ans[index-k+1]=pq.peek()[0]
        }
        return ans

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
