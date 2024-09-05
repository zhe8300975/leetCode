//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2744 👎 0


fun main(){
    CoinChange.Solution().coinChange(intArrayOf(1,2,5),11)
}
class CoinChange{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
      var dp=IntArray(amount+1){0}
         for( i in 1..amount){
             dp[i]=-1
            if(coins.contains(i)){
                dp[i]=1
            }else{
                coins.forEach { item->
                    if(i-item>0&&dp[i-item]>0){
                        dp[i]=if(dp[i]!=-1) Math.min(dp[i],dp[i-item]+1) else dp[i-item]+1
                    }
                }
            }
        }
        return dp[amount]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}