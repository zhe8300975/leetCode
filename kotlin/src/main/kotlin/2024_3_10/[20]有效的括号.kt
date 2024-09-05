import java.util.LinkedList

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4376 👎 0


fun main() {
    ValidParentheses.Solution().isValid("()")
}

class ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isValid(s: String): Boolean {
            var stack = LinkedList<Char>()
            s.toCharArray().forEach { item ->
                if (item == '(' || item == '{' || item == '[') {
                    stack.addLast(item)
                } else {
                    if (stack.isEmpty()) {
                        return false
                    }
                    var last = stack.last
                    when (item) {
                        ')' -> {
                            if (last == '(') {
                                stack.removeLast()
                            } else {
                                return false
                            }
                        }
                        '}' -> {
                            if (last == '{') {
                                stack.removeLast()
                            } else {
                                return false
                            }
                        }
                        ']' -> {
                            if (last == '[') {
                                stack.removeLast()
                            } else {
                                return false
                            }
                        }
                    }
                }
            }
            return stack.isEmpty()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}