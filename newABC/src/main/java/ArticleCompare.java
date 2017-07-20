import java.text.SimpleDateFormat;
import java.util.Comparator;

/**
 * Created by yueyue on 2017/7/12.
 */
public class ArticleCompare implements Comparator<Article> {

    public int  compare(Article art1,Article art2)
    {

        if(art1 == null || art2 == null)
            return 0;
        String dateTime1 = art1.getDateTime().toString();
        String dateTime2 = art2.getDateTime().toString();
//        if(art1.equals(art2))
//        {
//            return art1.getNum()>art2.getNum() ? 1: 0;
//        }
//        else
            if(dateTime1.equals(dateTime2))
        {
//            String[] newDateTime1 = dateTime1.split("[.]");
//            String[] newDateTime2 = dateTime2.split("[.]");
//
//            for(int i=0; i<newDateTime1.length;++i)
//            System.out.println("newDateTime1  "+newDateTime1);
//            StringBuffer new1 = new StringBuffer();
//            StringBuffer new2 = new StringBuffer();
//            for(String s:newDateTime1)
//                new1.append(s);
//            for(String s:newDateTime2)
//                new2.append(s);
//            System.out.println("I am "+new1);
//            return 0;
            //System.out.println("Compare DateTime  "+ newDateTime1.equals(newDateTime2));
            //return newDateTime1.equals(newDateTime2) ? 4:-1;
            return dateTime1.compareTo(dateTime2) > 0  ? -1 :1;
        }
        else if(art1.getNum() != art2.getNum())
        {
            return art1.getNum() > art2.getNum() ? -1:1;
        }
        else if(art1.getSort() != art2.getSort())
        {
            return art1.getSort() > art2.getSort() ? 1:-1;
        }
        else {
            String classification1 = art1.getClassification();
            String classification2 = art2.getClassification();
            return classification1.compareTo(classification2);
        }

    }

}
