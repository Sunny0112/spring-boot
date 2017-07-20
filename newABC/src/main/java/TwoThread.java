import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yueyue on 2017/7/12.
 */
public class TwoThread extends Thread {
    TwoThread(String s, Thread t,Queue<String> queue)
    {
        this.t = t;
        this.s = s;
        this.queue = queue;
    }
    public void run()
    {
        try{
            t.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("The "+s+" Thread");
        lock.lock();
        String str = queue.element();
        queue.remove();
        lock.unlock();
        System.out.println("I am"+str);
        try{sleep(1000);}catch(Exception e){e.printStackTrace();}

    }
    private String s;
    private Thread t;
    private Queue<String> queue;
    private static Lock lock = new ReentrantLock();

}
