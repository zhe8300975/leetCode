package one_done.`1`//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1572 👎 0

fun main() {
    val trie = ImplementTriePrefixTree.Trie()
    trie.insert("apple")
    trie.search("apple")
    trie.search("app")
    trie.startsWith("app")
    trie.insert("app")
    println( trie.search("app"))
}

class ImplementTriePrefixTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie() {

        val trie = Array<Trie?>(26) { null }
        val trieCharEnd = Array<Boolean>(26) { false }
        val trieChar = Array<Boolean>(26) { false }

        fun insert(word: String) {
            if (word.length == 1) {
                trieCharEnd[word[0] - 'a'] = true
                trieChar[word[0] - 'a'] = true
            } else {
                val index = word[0] - 'a'
                trieChar[index] = true
                (trie[index]?: run {
                    Trie().also { trie[index] = it }
                }).insert(word.substring(1, word.length))
            }
        }

        fun search(word: String): Boolean {
            if (word.length == 1) {
                return trieCharEnd[word[0] - 'a']
            } else {
                val index = word[0] - 'a'
                return trie[index]?.search(word.substring(1, word.length)) ?: false
            }
        }

        fun startsWith(prefix: String): Boolean {
            if (prefix.length == 1) {
                return trieChar[prefix[0] - 'a']
            } else {
                val index = prefix[0] - 'a'
                return trie[index]?.startsWith(prefix.substring(1, prefix.length)) ?: false
            }
        }

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */
//leetcode submit region end(Prohibit modification and deletion)

}
