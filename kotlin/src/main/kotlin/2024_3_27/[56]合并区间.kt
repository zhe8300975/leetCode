//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2282 👎 0


fun main(){
}
class MergeIntervals{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(Comparator { o1, o2 ->
            if (o1[0]==o2[0]){
                return@Comparator o1[1]-o2[1]
            }
            return@Comparator o1[0]-o2[0] })
        var ans=ArrayList<IntArray>()
        intervals.forEach { item->
            if(ans.isNotEmpty()){
                var last=ans.get(ans.size-1)
                if(last[0]<=item[0]&&last[1]>=item[1]){
                    return@forEach
                }
                if(last[0]<=item[0]&&last[1]>=item[0]&&item[1]>last[0]){
                    ans.get(ans.size-1)[1]=item[1]
                    return@forEach
                }
            }
            ans.add(intArrayOf(item[0],item[1]))
        }
        return ans.toTypedArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}