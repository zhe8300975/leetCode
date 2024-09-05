//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
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
// Related Topics 数组 字符串 回溯 矩阵 👍 1788 👎 0


fun main() {
}

class WordSearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            for (x in 0 until board.size) {
                for (y in 0 until board[0].size) {
                    if(exist(board, word, Array(board.size) { BooleanArray(board[0].size) }, x, y)){
                        return true
                    }
                }
            }
            return false
        }

        fun exist(board: Array<CharArray>, word: String, used: Array<BooleanArray>, x: Int, y: Int): Boolean {
            if (used[x][y] || word.isEmpty()) {
                return false
            } else if (board[x][y] == word[0]) {
                if (word.length == 1) {
                    return true
                } else {
                    var exist = false
                    used[x][y] = true
                    if (x > 0 && !used[x - 1][y]) {
                        exist = exist || exist(board, word.substring(1, word.length), used, x - 1, y)
                    }
                    if (x < board.size - 1 && !used[x + 1][y]) {
                        exist = exist || exist(board, word.substring(1, word.length), used, x + 1, y)
                    }
                    if (y > 0 && !used[x][y - 1]) {
                        exist = exist || exist(board, word.substring(1, word.length), used, x, y - 1)
                    }
                    if (y < board[0].size - 1 && !used[x][y + 1]) {
                        exist = exist || exist(board, word.substring(1, word.length), used, x, y + 1)
                    }
                    used[x][y] = false
                    return exist
                }
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}