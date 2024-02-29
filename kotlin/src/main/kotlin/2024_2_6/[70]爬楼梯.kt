//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3432 👎 0

fun main() {
    
}
class ClimbingStairs{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun climbStairs(n: Int): Int {
        if(n>=0&&n<=2){
            return n
        }
    
       var dp=IntArray(n+1)
        dp[0]=0
        dp[1]=1
        dp[2]=2
        for(index in 3.. n ){
            dp[index]=dp[index-1]+dp[index-2]
        }
        return dp[n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
