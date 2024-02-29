package one_done.`1`//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1729 👎 0

fun main() {
    WordSearch.Solution().exist(Array(3) {
        charArrayOf('A','B','C','E')
        charArrayOf('S','F','E','S')
        charArrayOf('A','D','E','E')
    }, "ABCESEEEFS")
}

class WordSearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            for (m in 0 until board.size) {
                for (n in 0 until board[0].size) {
                    if (exist(
                            board,
                            m,
                            n,
                            Array(board.size) { Array<Boolean>(board[0].size) { false } }, word, 0
                        )
                    ) {
                        return true
                    }
                }
            }
            return false
        }

        fun exist(
            board: Array<CharArray>,
            m: Int,
            n: Int,
            path: Array<Array<Boolean>>,
            word: String,
            index: Int
        ): Boolean {
            var exist = false
            if(!path[m][n]&&board[m][n]==word[index]) {
                path[m][n]=true
                if(index==word.length-1){
                    exist=true
                }
                if (m > 0  && !exist) {
                    exist = exist(board, m - 1, n, path, word, index + 1)
                }
                if (m < board.size - 1 && !exist) {
                    exist = exist(board, m + 1, n, path, word, index + 1)
                }

                if (n > 0 && !exist) {
                    exist = exist(board, m, n - 1, path, word, index + 1)
                }
                if (n < board[0].size - 1 && !exist) {
                    exist = exist(board, m, n + 1, path, word, index + 1)
                }
                path[m][n]=false
            }
            return exist

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

