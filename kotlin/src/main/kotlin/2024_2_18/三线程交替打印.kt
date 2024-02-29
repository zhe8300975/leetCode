import data.ListNode
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


//0--100交替打印
@Volatile
var num=0

fun main() {
    val lock=ReentrantLock()
    var condition=lock.newCondition()
    Thread({runThread(lock,3,0,condition)},"线程1").start()
    Thread({runThread(lock,3,1,condition)},"线程2").start()
    Thread({runThread(lock,3,2,condition)},"线程3").start()
}

fun runThread(lock: Lock,count:Int,cur:Int,condition: Condition){
    lock.lock()
    try {
        while(true){
            while(num%count!=cur&&num<=100){
                condition.await()
            }
            if(num<=100) {
                println("${Thread.currentThread()}+ :${num}")
                num++
                condition.signalAll()
            }else{
                condition.signalAll()
                break
            }
        }
    }finally {
        lock.unlock()
    }
}




