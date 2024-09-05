//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1823 👎 0


fun main() {
}

class RotateImage {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate(matrix: Array<IntArray>): Unit {
            for (i in 0 until matrix.size) {
                for (j in 0..i) {
                    swipe(matrix,i,j,j,i)
                }
            }
            for(i in 0 until matrix.size){
                for(j in 0 until  matrix.size/2){
                    swipe(matrix,i,j,i,matrix.size-1-j)
                }
            }
        }

        fun swipe(matrixs: Array<IntArray>, oldX: Int, oldY: Int, newX: Int, newY: Int) {
            var num = matrixs[oldX][oldY]
            matrixs[oldX][oldY] = matrixs[newX][newY]
            matrixs[newX][newY] = num
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}