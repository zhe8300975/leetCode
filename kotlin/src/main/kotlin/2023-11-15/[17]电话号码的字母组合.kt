package `2023-11-15`

import java.lang.StringBuilder

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2682 👎 0

fun main() {
    ;
}

class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        var map = HashMap<Char, CharArray>().apply {
            this['2'] = charArrayOf('a', 'b', 'c')
            this['3'] = charArrayOf('d', 'e', 'f')
            this['4'] = charArrayOf('g', 'h', 'i')
            this['5'] = charArrayOf('j', 'k', 'l')
            this['6'] = charArrayOf('m', 'n', 'o')
            this['7'] = charArrayOf('p', 'q', 'r', 's')
            this['8'] = charArrayOf('t', 'u', 'v')
            this['9'] = charArrayOf('w', 'x', 'y', 'z')
        }

        fun letterCombinations(digits: String): List<String> {
            var ans = ArrayList<String>()
            if (digits.length > 0) {
                letterCombinations(digits, 0, StringBuilder(), ans)
            }
            return ans
        }

        fun letterCombinations(digits: String, index: Int, path: StringBuilder, ans: ArrayList<String>) {
            if (index < digits.length) {
                map[digits[index]]?.forEach { item ->
                    path.append(item)
                    letterCombinations(digits, index + 1, path, ans)
                    path.deleteCharAt(path.length - 1)
                }
            } else {
                ans.add(path.toString())
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}