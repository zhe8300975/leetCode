//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 229 👎 0


fun main() {
}

class SmallestKLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun smallestK(arr: IntArray, k: Int): IntArray {
            if(k==0) return IntArray(0)
            return smallestK(arr,k,0,arr.size-1)
        }

        fun smallestK(arr: IntArray, k: Int, start: Int, end: Int): IntArray {
            var pre=start
            var index=start
            while(pre<end){
                var num=arr[end]
                if(arr[pre]<arr[end]){
                    swipe(arr,pre,index)
                    index++
                }
                pre++
            }
            swipe(arr,index,end)
            if(index==k-1){
                return IntArray(k){i->arr[i]}
            }else{
                return if(index>k-1){
                    return smallestK(arr,k,start,index-1)
                }else{
                    return smallestK(arr,k,index+1,end)
                }
            }
        }

        fun swipe(arr: IntArray,index1:Int,index2:Int){
            var num=arr[index1]
            arr[index1]=arr[index2]
            arr[index2]=num
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}