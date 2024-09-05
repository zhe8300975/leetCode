//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1654 👎 0


fun main() {
}

class MaximalSquare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximalSquare(matrix: Array<CharArray>): Int {
            var dp = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) }
            var ans = 0
            for (x in 0 until matrix.size) {
                for (y in 0 until matrix[0].size) {
                    if (matrix[x][y] == '1') {
                        if (x == 0 || y == 0) {
                            dp[x][y] = 1
                        } else {
                            dp[x][y] = Math.min(dp[x - 1][y - 1], Math.min(dp[x - 1][y], dp[x][y - 1])) + 1
                        }
                        ans = Math.max(ans, dp[x][y] * dp[x][y])
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}