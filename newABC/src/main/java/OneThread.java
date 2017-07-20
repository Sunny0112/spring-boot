import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yueyue on 2017/7/12.
 */
public class OneThread extends Thread {
    OneThread(String s, Queue<String> queue)
    {
        this.s = s;
        this.queue = queue;

    }
    public void run()
    {
        System.out.print(s);
//        System.out.println("The "+s+" pthread");
//        lock.lock();
//        String str = queue.element();
//        queue.remove();
//        lock.unlock();
//        System.out.println("I am"+str);
//        try{sleep(1000);}catch(Exception e){e.printStackTrace();}

    }
    private Thread t ;
    private String s;
    private Queue<String> queue;
    private static Lock lock = new ReentrantLock();

}
