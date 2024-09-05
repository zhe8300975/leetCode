//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
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
// Related Topics 字符串 动态规划 👍 3348 👎 0


fun main(){
}
class EditDistance{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        var dp=Array<IntArray>(word1.length+1){IntArray(word2.length+1)}
        for(x in 1 .. word1.length){
            dp[x][0]=dp[x-1][0]+1
        }
        for(y in 1 .. word2.length){
            dp[0][y]=dp[0][y-1]+1
        }

        for(x in 1 .. word1.length){
            for(y in 1 .. word2.length){
                if(word1[x-1]==word2[y-1]){
                    dp[x][y]=dp[x-1][y-1]
                }else{
                    dp[x][y]=Math.min(dp[x-1][y-1],Math.min(dp[x-1][y],dp[x][y-1]))+1
                }
            }
        }

        return dp[word1.length][word2.length]

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}