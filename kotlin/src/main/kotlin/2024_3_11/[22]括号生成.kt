//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3530 👎 0


fun main() {
}

class GenerateParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            var ans = ArrayList<String>()
            generateParenthesis(n, n, StringBuilder(), ans)
            return ans
        }

        fun generateParenthesis(leftNum: Int, rightNum: Int, path: StringBuilder, ans: ArrayList<String>) {
            if (leftNum == 0 && rightNum == 0) {
                ans.add(path.toString())
                return
            }

            if (leftNum <= rightNum && leftNum > 0) {
                path.append("(")
                generateParenthesis(leftNum - 1, rightNum, path, ans)
                path.deleteAt(path.length - 1)
            }
            if (leftNum < rightNum) {
                path.append(")")
                generateParenthesis(leftNum, rightNum - 1, path, ans)
                path.deleteAt(path.length - 1)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}