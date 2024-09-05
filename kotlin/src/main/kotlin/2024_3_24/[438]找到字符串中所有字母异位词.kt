import java.util.*
import kotlin.collections.ArrayList

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1407 👎 0


fun main(){
    FindAllAnagramsInAString.Solution().findAnagrams("cbaebabacd","abc")

}

class FindAllAnagramsInAString{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        var tager=getTarget(p)
        var end=p.length-1
        var ans=ArrayList<Int>()
        while(end<s.length){
            var car=getTarget(s.substring(end-p.length+1,end+1))
            if(car.equals(tager)){
                ans.add(end-p.length+1)
            }
            end++
        }
        return ans
    }

        fun getTarget(str:String):String{
            var charList=str.toCharArray()
            Arrays.sort(charList)
            return String(charList)
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}