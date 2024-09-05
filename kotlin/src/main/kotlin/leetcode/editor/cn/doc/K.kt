package editor.cn.doc

import kotlinx.coroutines.*
import java.util.PriorityQueue
import java.util.concurrent.Executors
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis



fun main() {
    val myThreadPool = Executors.newFixedThreadPool(4)
    val myContext = myThreadPool.asCoroutineDispatcher()

    repeat(10) {
        GlobalScope.launch(myContext) {
            println("Running in thread: ${Thread.currentThread().name}")
        }
    }

    Thread.sleep(1000) // 等待足够长的时间，以确保协程有机会执行
    myThreadPool.shutdown() // 关闭线程池
}

// fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val a = async(Dispatchers.IO, CoroutineStart.LAZY) {
//            printWithThreadInfo()
//            delay(1000) // 模拟耗时操作
//            1
//        }
//        val b = async(Dispatchers.IO, CoroutineStart.LAZY) {
//            printWithThreadInfo()
//            delay(2000) // 模拟耗时操作
//            2
//        }
////        a.start()
////        b.start()
//        printWithThreadInfo("${a.await() + b.await()}")
//        printWithThreadInfo("end")
//    }
//    printWithThreadInfo("time: $time")
//}
fun <T> T.printWithThreadInfo(message: String? = null) {
    val threadInfo = Thread.currentThread().name
    if (message != null) {
        println("[$threadInfo] $message")
    } else {
        println("[$threadInfo] $this")
    }
}




//fun main() = runBlocking {
//    val job = launch {
//        try {
//            delay(40)
//            println("try...")
//        } catch (e: Exception) {
//            println("exception: ${e.message}")
//        } finally {
//            println("finally...")
//        }
//        delay(40)
//        println("try..11.")
//    }
//    delay(50)
//    println("cancel")
//    job.cancel()
//    print("Done")
//}
//fun main(){
//
//    runBlocking {
//        val job = launch {
//            repeat(1000) { i ->
//                println("job: test $i ...")
//                delay(500L)
//            }
//        }
//        delay(1300L) // 延迟一段时间
//        println("main: ready to cancel!")
//
//        job.join() // 等待作业执行结束
//        job.cancel() // 取消该作业
//        println("main: Now cancel.")
//    }
//}
class K {
    private val svJob = SupervisorJob()
    private val mDispatcher = newSingleThreadContext("test_dispatcher")

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        printWithThreadInfo("exceptionHandler: throwable: $throwable")
    }

    private val svScope = CoroutineScope(svJob + mDispatcher + exceptionHandler)
    private val mScope = CoroutineScope(Job() + mDispatcher + exceptionHandler)

//    svScope.launch {}
//
//// 或者
//    supervisorScope {
//        launch {
//            ...
//        }
//    }launch
}