//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5139 👎 0


fun main(){
}
class TrappingRainWater{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun trap(height: IntArray): Int {
        var leftMax=IntArray(height.size)
        var rightMax=IntArray(height.size)
        for(i in 0 until height.size){
            leftMax[i]=Math.max(height[i],leftMax.getOrElse(i-1,{0}))
        }
        for(i in height.size-1 downTo 0){
            rightMax[i]=Math.max(height[i],rightMax.getOrElse(i+1,{0}))
        }
        var ans=0
        for(i in 1 .. height.size-2){
            var h=Math.min(leftMax[i-1],rightMax[i+1])
            if(h>height[i]){
                ans+=h-height[i]
            }
        }
        return ans

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}