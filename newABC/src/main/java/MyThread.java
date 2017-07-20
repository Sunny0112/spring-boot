import java.io.Writer;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//建三个信号量分别时ABC的信号量，进行相互通知，先执行A，执行完后释放B的信号量执行B，B执行后释放C的信号量执行C，再释放A的信号量，循环
/**
 * Created by yueyue on 2017/7/11.
 */
public class MyThread extends Thread {
    MyThread(String ss, Semaphore sem, Queue<String> queue)
    {
        s=ss;
        this.sem = sem;
        this.queue = queue;
    }
    MyThread(String s, Queue<String> queue,CyclicBarrier cyclicBarrier)
    {
        this.s = s;
        this.queue = queue;
        this.cyclicBarrier = cyclicBarrier;
    }
//问题所在：线程可以分批执行，一批线程判断是否为自己所该输出的问题时出错
// 三个线程每次只进入AAA代码段输出队列里的值


    public void run()
    {
        try{
            //sem.acquire();

           //执行过程


            //System.out.println(s + "正在执行......");

                lock.lock();
                if("A".equals(c))
                {
                    System.out.println(s + "正在执行......");
                    //System.out.println("AAA");
                    String str = queue.element();
                    queue.remove();
                    c = "B";
                    System.out.println("I am"+str);
                }
                else if(Objects.equals("B", c))
                {
                    System.out.println(s + "正在执行......");
                    //System.out.println("BBBB");
                    String str = queue.element();
                    queue.remove();
                    c = "C";
                    System.out.println("I am"+str);
                }
                else  if(Objects.equals("C", c))
                {
                    System.out.println(s + "正在执行......");
                    //System.out.println("CCCC");
                    String str = queue.element();
                    queue.remove();
                    c = "A";
                    System.out.println("I am "+str);
                }
                lock.unlock();

            sleep(1000);
            cyclicBarrier.await();
            //sem.release();

        }
       catch(InterruptedException e)
       {
           e.printStackTrace();
       }
       catch (BrokenBarrierException e)
       {
           e.printStackTrace();
       }

    }
    private String s;
    private Semaphore sem;
    private Queue<String> queue;
    private CyclicBarrier cyclicBarrier;
    private static Lock lock = new ReentrantLock();
    private static String c = "A";
}
