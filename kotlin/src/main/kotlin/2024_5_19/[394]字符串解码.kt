import java.util.LinkedList

//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1748 👎 0


fun main() {
    DecodeString.Solution().decodeString("3[a]2[bc]")
}

class DecodeString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun decodeString(s: String): String {
            var ans = StringBuilder()
            var queue = LinkedList<String>()
            var index = 0
            while (index < s.length) {
                var num = 0
                while (s[index] <= '9' && s[index] >= '0') {
                    num = num * 10 + (s[index] - '0')
                    index++
                }
                if (num != 0) {
                    queue.addLast(num.toString())
                }
                if (s[index] != ']') {
                    queue.add(s[index].toString())
                } else {
                    var str = StringBuilder()
                    while (!"[".equals(queue.last)) {
                        str.append(queue.removeLast())
                    }
                    queue.removeLast()
                    var num=queue.removeLast().toInt()
                    for(i in 1 .. num){
                        for(j in str.length-1 downTo 0){
                            queue.addLast(str[j].toString())
                        }
                    }
                }
                index++
            }
            while(queue.isNotEmpty()){
                ans.append(queue.removeLast())
            }
            return  ans.reverse().toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}