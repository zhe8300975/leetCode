//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1642 👎 0

fun main() {
    
}
class MinimumPathSum{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        var dp=IntArray(grid[0].size){0}
        for(x in 0 until grid.size){
            for(y in 0 until grid[0].size){
                if(x==0){
                    dp[y]=grid[x][y]+dp.getOrElse(y-1) { 0 }
                }else{
                    dp[y]=grid[x][y]+if(y==0) dp[y] else Math.min(dp[y],dp[y-1])
                }
            }
        }
        return dp[grid[0].size-1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
