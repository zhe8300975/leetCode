//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
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
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2499 👎 0


fun main(){

}
class UniqueBinarySearchTrees{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numTrees(n: Int): Int {
        if(n==0||n==1){
            return n
        }
        var dp=IntArray(n+1){0}
        dp[0]=1
        dp[1]=1
        for(i in 2 .. n){
            for(left in 0 ..i-1)
            dp[i]+=dp[left]*dp[i-1-left]
        }
        return dp[n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}