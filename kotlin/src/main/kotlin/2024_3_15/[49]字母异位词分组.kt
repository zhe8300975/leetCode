import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1846 👎 0


fun main() {
}

class GroupAnagrams {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            var map = HashMap<String, ArrayList<String>>()
            strs.forEach { item ->
                var array = item.toCharArray()
                Arrays.sort(array)
                map.getOrPut(String(array)) { ArrayList<String>() }.add(item)
            }
            var ans=ArrayList<List<String>>()
            map.values.forEach { item->
                ans.add(item)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}