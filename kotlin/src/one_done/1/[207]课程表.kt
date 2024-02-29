package one_done.`1`

import java.util.LinkedList

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1853 👎 0

fun main() {
    CourseSchedule.Solution().canFinish(2, Array<IntArray>(1){ intArrayOf(1,0) })
}

class CourseSchedule {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            //没门课程需要的前置个数
            val dp = Array<Int>(numCourses){0}
            val list = Array<ArrayList<Int>>(numCourses) { ArrayList() }
            val queue = LinkedList<Int>()
            for (array in prerequisites) {
                dp[array[0]]++
                list[array[1]].add(array[0])
            }
            dp.forEachIndexed { index, value ->
                if (value == 0) {
                    queue.add(index)
                }

            }
            while (queue.isNotEmpty()) {
                val value = queue.removeFirst()
                list[value].forEach {
                    if (--dp[it] == 0) {
                        queue.add(it)
                    }
                }
            }

            dp.forEach { if (it != 0) return false }
            return true


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
