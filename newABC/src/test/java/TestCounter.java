
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yueyue on 2017/7/13.
 */
public class TestCounter {

    @Test
    public void testCounter() throws InterruptedException {

//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("key1", "One");
//        map.put("key2", "Two");
//        String qmap = null;
//        qmap = JSON.toJSONString(qmap);
//        System.out.println(qmap);
//
//        Map<String,Object> map1 = JSON.parseObject(qmap,Map.class);
//        System.out.println(map1);

        Calendar c1 = Calendar.getInstance();
       c1.set(2009, 6 , 12);
        Article art = new Article("yueyue",c1,0,10,"white");
         String Json = JSON.toJSONString(art, SerializerFeature.WriteDateUseDateFormat);
         System.out.println(Json);

        Article pArt = JSON.parseObject(Json,Article.class);
        System.out.println(pArt);
//        Calendar c1 = Calendar.getInstance();
//        c1.set(2009, 6 , 12);
//        Calendar c2 = Calendar.getInstance();
//        c2.set(2010, 2 , 12);
//        Calendar c3 = Calendar.getInstance();
//        c3.set(2019, 3 , 22);
//        Calendar c4 = Calendar.getInstance();
//        c4.set(2018, 6 , 22);
//        Calendar c5 = Calendar.getInstance();
//        c5.set(2034, 9 , 12);
//
//        //System.out.print("Date: "+c1.get(Calendar.MONTH)+" " + c1.get(Calendar.DATE) + " "+" " + c1.get(Calendar.SECOND) + " ");
//        Counter counter = new Counter();
//        counter.add("1",new Article("yueyue",c1,0,10,"white"));
//        counter.add("2",new Article("yueyue",c2,0,10,"white"));
//        counter.add("3",new Article("yueyue",c3,0,10,"white"));
//        counter.add("4",new Article("yueyue",c4,0,11,"white"));
//        counter.add("5",new Article("yueyue",c5,0,11,"black"));
//
//
//        Thread t1 = new CountThread(counter,"1");
//        Thread t2 = new CountThread(counter,"2");
//        Thread t3 = new CountThread(counter,"3");
//        Thread t4 = new CountThread(counter,"4");
//        Thread t5 = new CountThread(counter,"5");
//        Thread t6 = new CountThread(counter,"4");
//        Thread t7 = new CountThread(counter,"9");
//
//        ExecutorService pool = Executors.newCachedThreadPool();
//
//        int i=0;
//        while(i<10) {
//            pool.execute(t1);
//            pool.execute(t2);
//            pool.execute(t3);
//            pool.execute(t4);
//            pool.execute(t5);
//            pool.execute(t6);
//            pool.execute(t7);
//
//            i++;
//
//        }
//
//
//        Thread.sleep(1000000);

//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            map.putIfAbsent("val" + i, i);
//        }
//
//        map.merge("val10", 100, (val, oval) -> ++val);
//        System.out.println(map.get("val10"));
//        map.merge("val10", 100, (val, oval) -> ++oval);
//        System.out.println(map.get("val10"));
//        map.merge("val10", 100, (val, oval) -> ++val);
//        System.out.println(map.get("val10"));
    }

}

