//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1304 👎 0


fun main() {
}

class PalindromicSubstrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countSubstrings(s: String): Int {
            var dp = Array(s.length) { BooleanArray(s.length) }
            var ans = 0
            for (x in s.length - 1 downTo 0) {
                for (y in x until s.length) {
                    if (x == y) {
                        dp[x][y] = true
                    } else if (x + 1 == y) {
                        dp[x][y] = s[x] == s[y]
                    } else {
                        (dp[x + 1][y - 1] && s[x] == s[y]).also { dp[x][y] = it }
                    }
                    if (dp[x][y]) {
                        ans++
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}