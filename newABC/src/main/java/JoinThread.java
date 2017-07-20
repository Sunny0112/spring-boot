import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yueyue on 2017/7/12.
 */

//存在问题： 新建三个线程，start执行正确，加入线程池执行错误。
// 错误原因：
public class JoinThread {
    JoinThread(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; ++i) {
        Thread t1 = new OneThread("X", queue);
        Thread t2 = new OneThread("Y", queue);
        Thread t3 = new OneThread("Z",queue);
        int tab=0;

//            System.out.println(tab++);
            try {
                t1.start();
                t1.join();
                t2.start();
                t2.join();
                t3.start();
                t3.join();
//                pool.execute(t1);
//                pool.execute(t2);
//                pool.execute(t3);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private Queue<String> queue;
}