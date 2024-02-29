//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7068 👎 0

fun main() {
    
}
class LongestPalindromicSubstring{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): String {
        var ansStart=0
        var ansEnd=0
        var dp=Array<BooleanArray>(s.length){ BooleanArray(s.length) }
        for(start in s.length-1 downTo 0){
            for(end in start until s.length){
                if(start==end){
                    dp[start][end]=true
                }else if(end-start==1){
                    dp[start][end]=s[start]==s[end]
                }else {
                    dp[start][end]=s[start]==s[end]&&dp[start+1][end-1]
                }
                if(dp[start][end]&&end-start>ansEnd-ansStart){
                    ansEnd=end
                    ansStart=start
                }
            }
        }
        return s.substring(ansStart,ansEnd+1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
