package one_done.`1`//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2419 👎 0

fun main() {
    UniqueBinarySearchTrees.Solution().numTrees(3)
}
class UniqueBinarySearchTrees{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numTrees(n: Int): Int {
        val dp=Array<Int>(n+1){0}
        dp[1]=1
        for(i in 2..n){
            for(leftNum in 0 until i){
                dp[i]+=Math.max(dp[leftNum],1)*Math.max(dp[i-1-leftNum],1)
            }
        }
        return dp[n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
