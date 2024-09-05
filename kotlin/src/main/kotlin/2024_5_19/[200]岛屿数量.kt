//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2477 👎 0


fun main() {
}

class NumberOfIslands {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            var ans=0
            for (x in 0 until grid.size) {
                for (y in 0 until grid[0].size) {
                    if(grid[x][y]=='1'){
                        checkout(grid,x,y)
                        ans++
                    }
                }
            }
            return ans
        }

        fun checkout(grid: Array<CharArray>, x: Int, y: Int) {
            grid[x][y] = '0'
            if (x > 0 && grid[x - 1][y] == '1') {
                checkout(grid, x - 1, y)
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                checkout(grid, x, y - 1)
            }
            if (x < grid.size - 1 && grid[x + 1][y] == '1') {
                checkout(grid, x + 1, y)
            }
            if (y < grid[0].size - 1 && grid[x][y + 1] == '1') {
                checkout(grid, x, y + 1)
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}