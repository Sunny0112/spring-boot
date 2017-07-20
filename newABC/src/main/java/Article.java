/**
 * Created by yueyue on 2017/7/12.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Article {
    private String title;
    private Calendar dateTime;
    public int num;
    private int sort;
    private String classification;

    public Article()
    {
    }

    public Article(String title,Calendar dataTime,int num, int sort, String classification)
    {
        this.title = title;
        this.dateTime = dataTime;
        this.num = num;
        this.sort = sort;
        this.classification = classification;
    }
    public String getTitle() {
        return title;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public int getNum() {
        return num;
    }

    public int getSort() {
        return sort;
    }

    public String getClassification() {
        return classification;
    }
    public boolean equals(Article art)
    {
        if((this.title.compareTo(art.title)==0) && (this.dateTime.equals(art.dateTime)));
                return true;
    }
    public int hashcode()
    {
        int hash = this.hashCode();
        return hash^this.num;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return String.format("%tc\t\t%d\t\t%d\t\t%s\t\t%s",this.getDateTime(),this.getNum(),this.getSort(),this.getClassification(),this.getTitle());
    }
}
