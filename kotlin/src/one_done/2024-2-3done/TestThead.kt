package one_done.`2024-2-3done`

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

object TestThead {
    private val lock: Lock = ReentrantLock(true)
    private val condition: Condition = lock.newCondition()

    @Volatile
    private var index = 1
    private const val count = 3

    @JvmStatic
    fun main(args: Array<String>) {
        MyThread("A", 1).start()
        MyThread("B", 2).start()
        MyThread("C", 3).start()
    }

    internal class MyThread(var value: String, var num: Int) : Thread() {
        override fun run() {
            lock.lock()
            for (i in 0..99) {
                while (index != num) {
                    condition.await()
                }
                println(value)
                println(
                    "当前线程：" + currentThread()
                        .name + ":" + value
                )
                index = index % count + 1
                condition.signalAll()
            }
            lock.unlock()
        }
    } //
}
