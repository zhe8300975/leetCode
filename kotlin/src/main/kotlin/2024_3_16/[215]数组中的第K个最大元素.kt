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
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2424 👎 0


fun main() {
    KthLargestElementInAnArray.Solution().findKthLargest(intArrayOf(3,2,1,5,6,4),2)
}

class KthLargestElementInAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            var queue = PriorityQueue<Int>(Comparator { o1, o2 -> o2-o1 })
            nums.forEach { item->
                queue.add(item)
            }
            for(i in 1 until  k ){
                queue.remove()
            }
            return queue.first()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}