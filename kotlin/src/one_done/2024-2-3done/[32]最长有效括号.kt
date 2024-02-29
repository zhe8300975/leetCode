package one_done.`2024-2-3done`//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2429 👎 0

fun main() {
    
}
class LongestValidParentheses{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestValidParentheses(s: String): Int {
        var max=0
        var dp=IntArray(s.length)
        for(i in 1 until s.length){
            if(s[i]==')'){
                if(s[i-1]=='('){
                    dp[i]=2+(if(i>=2) dp[i-2] else 0)
                }else if(i-dp[i-1]-1>=0&&s[i-dp[i-1]-1]=='('){
                    dp[i]=dp[i-1]+2+if(i-dp[i-1]-2>=0) dp[i-dp[i-1]-2] else 0
                }
                max=Math.max(max,dp[i])
            }
        }
        return max
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
