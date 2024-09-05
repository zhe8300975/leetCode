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
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2438 👎 0


fun main() {
}

class KthLargestElementInAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            var queue = PriorityQueue<Int>(Comparator { o1, o2 -> return@Comparator o2 - o1 })
            nums.forEach { item ->
                queue.add(item)
            }
            for( i in 1 until k){
                queue.poll()
            }
            return queue.peek()
        }
//        fun findKthLargest(nums: IntArray, k: Int): Int {
//            var start = 0
//            var end = nums.size - 1
//            while (true) {
//                var pre = start
//                for (index in start until end) {
//                    if (nums[index] < nums[end]) {
//                        swipe(nums, index, pre++)
//                    }
//                }
//                swipe(nums, pre, end)
//                if (pre == nums.size - k) {
//                    return nums[pre]
//                }else if(pre>nums.size-k){
//                    end=pre-1
//                }else{
//                    start=pre+1
//                }
//            }
//            return -1
//
//        }
//
//
//        fun swipe(nums: IntArray, index1: Int, index2: Int) {
//            var num = nums[index1]
//            nums[index1] = nums[index2]
//            nums[index2 ]= num
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}