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
// Related Topics 哈希表 字符串 回溯 👍 2773 👎 0


fun main() {
}

class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        var map = HashMap<Char, String>().apply {
            this['2'] = "abc"
            this['3'] = "def"
            this['4'] = "ghi"
            this['5'] = "jkl"
            this['6'] = "mno"
            this['7'] = "pqrs"
            this['8'] = "tuv"
            this['9'] = "wxyz"
        }

        fun letterCombinations(digits: String): List<String> {
            var ans = ArrayList<String>()
            if(digits.isNotEmpty()) {
                letterCombinations(digits, 0, StringBuilder(), ans)
            }
            return ans
        }

        fun letterCombinations(digits: String, index: Int, path: StringBuilder, ans: ArrayList<String>) {
            if(index==digits.length){
                ans.add(path.toString())
                return
            }
            map[digits[index]]?.forEach { item->
                path.append(item)
                letterCombinations(digits,index+1,path,ans)
                path.deleteAt(path.length-1)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}