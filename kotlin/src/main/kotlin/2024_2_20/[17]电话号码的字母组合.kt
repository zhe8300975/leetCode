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
// Related Topics 哈希表 字符串 回溯 👍 2759 👎 0

fun main() {

}

class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        val map = HashMap<Char, String>().apply {
            this.put('2', "abc")
            this.put('3', "edf")
            this.put('4', "ghi")
            this.put('5', "jkl")
            this.put('6', "mno")
            this.put('7', "pqrs")
            this.put('8', "tuv")
            this.put('9', "wxyz")
        }

        fun letterCombinations(digits: String): List<String> {

            var ans = ArrayList<String>()
            if(digits.isEmpty()){
                return ans
            }
            var path = StringBuilder()
            letterCombinations(digits, 0, ans, path)
            return ans
        }

        fun letterCombinations(digits: String, index: Int, ans: ArrayList<String>, path: StringBuilder) {
            if(index==digits.length){
                ans.add(path.toString())
                return
            }
            map[digits[index]]?.forEach {
                path.append(it)
                letterCombinations(digits,index+1,ans,path)
                path.deleteCharAt(path.length-1)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
