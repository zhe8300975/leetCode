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
// Related Topics 字符串 动态规划 👍 7102 👎 0


fun main(){
}
class LongestPalindromicSubstring{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): String {
        if(s.isEmpty()){
            return s
        }
        var ansStart=0
        var ansEnd=0
        var dp =Array(s.length){BooleanArray(s.length){false} }
        for( x in s.length-1 downTo 0){
            for(y in x until s.length){
                if(x==y){
                    dp[x][y]=true
                }else if(y-x==1){
                    dp[x][y]=s[x]==s[y]
                }else{
                    dp[x][y]=s[x]==s[y]&&dp[x+1][y-1]
                }
                if(dp[x][y]&&ansEnd-ansStart<y-x){
                    ansStart=x
                    ansEnd=y
                }
            }
        }
        return s.substring(ansStart,ansEnd+1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}