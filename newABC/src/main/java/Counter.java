import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yueyue on 2017/7/13.
 */
public class Counter {
    private Map<String,Article> articleHash = new ConcurrentHashMap<>();
    private String str;
    private Article art;
    public void increaseNum(String s)
    {
        Calendar c1 = Calendar.getInstance();
        c1.set(2009, 6 , 12);
        Article art = articleHash.get(s);
                        art = new Article("new", c1, 1, 99, "bless");
                        articleHash.merge(s, art, (val, oval) -> {
                                    AtomicInteger ai = new AtomicInteger(val.num);
                                    val.num = ai.incrementAndGet();
                            return val;
                                }
                            );
//
//        Article art = articleHash.get(s);
//        if(art == null){
//            synchronized (articleHash)
//       {
//            if(art == null)
//           {
//               art = new Article("new","8888",0,10,"bless");
//               this.add(s,art);
//           }
//       }
//        }
//
//        AtomicInteger ai = new AtomicInteger(art.num);
//        art.num = ai.incrementAndGet();
        //System.out.println(articleHash.get(s));
    }

    public Counter()
    {
        Timer timer = new Timer(true);
        timer.schedule(new java.util.TimerTask() { public void run(){
            for (Map.Entry entry : articleHash.entrySet()) {
                System.out.println(entry);

            }
        }
        } ,0,2000);
    }
    public void add(String s, Article art)
    {
        articleHash.put(s,art);
    }
}