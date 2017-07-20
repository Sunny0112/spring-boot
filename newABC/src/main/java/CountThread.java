/**
 * Created by yueyue on 2017/7/13.
 */
public class CountThread extends Thread {
    private Counter counter;
    private String s;

    public CountThread(Counter counter, String s) {
        this.counter = counter;
        this.s = s;
    }
    public void run() {
        counter.increaseNum(s);
    }
}
