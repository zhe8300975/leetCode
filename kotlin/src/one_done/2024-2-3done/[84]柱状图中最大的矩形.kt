package one_done.`2024-2-3done`

import java.util.LinkedList

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2643 👎 0

fun main() {
    
}
class LargestRectangleInHistogram{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var left=IntArray(heights.size)
        var right=IntArray(heights.size)
        var stack=LinkedList<Int>()
        for(index in 0 until  heights.size){
            while (stack.isNotEmpty()&&heights[stack.last()]>=heights[index]) {
                stack.removeLast()
            }
            left[index]=if(stack.isEmpty()) -1 else stack.last()
            stack.addLast(index)
        }
        stack.clear()
        for( index in heights.size-1 downTo 0){
            while(stack.isNotEmpty()&&heights[stack.last]>=heights[index]){
                stack.removeLast()
            }
            right[index]= if(stack.isEmpty()) heights.size else stack.last
            stack.add(index)
        }

var ans=0
        for(index in 0 until heights.size){
            ans=Math.max(ans,(right[index]-left[index]-1)*heights[index])
        }
        return  ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
