import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by yueyue on 2017/7/11.
 */

public class Pthreadpool {
    Queue<String> queue;
    Pthreadpool(Queue<String> queue)
    {
        this.queue = queue;
    }
    public void run() {
//        CyclicBarrier     CountDownLatch

//        Thread.join()
        ExecutorService pool = Executors.newFixedThreadPool(3);
//        Semaphore sem = new Semaphore(1);
//
//
//
//
//        Thread t1 = new MyThread("Pthread one",sem,queue);
//        Thread t2 = new MyThread("Pthread two",sem,queue);
//        Thread t3 = new MyThread("Pthread three",sem,queue);

        Thread t1,t2,t3;
        int N = 3;
        CyclicBarrier barrier = new CyclicBarrier(N);

        t1 = new MyThread("A", queue,barrier);
        t2 = new MyThread("B",  queue,barrier);
        t3 = new MyThread("C", queue,barrier);

           int i=1;
           while(i <= 10) {
        //try{
                //sem.acquire();
                pool.execute(t1);
                //sem.release();
                //sem.acquire();
                pool.execute(t2);
                //sem.release();
                //sem.acquire();
                pool.execute(t3);
                //sem.release();
            //}
            //catch (InterruptedException e)
            //{
            //    e.printStackTrace();
            //}
            //finally {
                i++;
            //}
        }

        pool.shutdown();
    }

}
