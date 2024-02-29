package one_done.`1`//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3233 👎 0

fun main() {
EditDistance.Solution().minDistance("","")
}

class EditDistance {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            val m = word1.length
            val n = word2.length
            val dp = Array(m + 1) { Array(n + 1) { 0 } }
            for (i in 1..m) {
                dp[i][0] = dp[i - 1][0] + 1
            }
            for (j in 1..n) {
                dp[0][j] = dp[0][j - 1] + 1
            }

            for (i in 1..m) {
                for (j in 1..n) {
                    if (word1[i - 1] == word2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
                    }

                }
            }
            return dp[m][n]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
