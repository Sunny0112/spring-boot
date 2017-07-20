import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yueyue on 2017/7/12.
 */
public class SortText {
    public  void sort()
    {
        Article art1,art2;
        List<Article> array = new ArrayList<Article>();
        {

            Counter counter = new Counter();
            Calendar c1 = Calendar.getInstance();
            c1.set(2009, 6 , 12);
            Calendar c2 = Calendar.getInstance();
            c2.set(2009, 6 , 12);
            Calendar c3 = Calendar.getInstance();
            c3.set(2009, 6 , 12);
            Calendar c4 = Calendar.getInstance();
            c4.set(2009, 6 , 12);
            Calendar c5 = Calendar.getInstance();
            c5.set(2009, 6 , 12);
            array.add(new Article("yueyue",c1,100,10,"white"));
            array.add(new Article("yueyue",c2,100,10,"white"));
            array.add(new Article("yueyue",c3,101,10,"white"));
            array.add(new Article("yueyue",c4,101,11,"white"));
            array.add(new Article("yueyue",c5,101,11,"black"));
            array.add(new Article("sunny",c5,101,11,"white"));
        }

        Collections.sort(array,new ArticleCompare());
        System.out.println("Date   "+"       num         "+"sort      "+"classification     "+"title  ");
        System.out.println("         |          |          |            |                  ");

        for(Article article:array)
        {
            System.out.println(article);
        }
    }

}
