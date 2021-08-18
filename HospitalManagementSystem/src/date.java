  import java.io.Serializable;
public class date implements Serializable{
    private String day;
    private String Month;
    private String year;
    public date(String y)
    {
        
    }
    public date(String a,String b,String d)
    {
        day=a;
        Month=b;
        year=d;
    }
    public String getday()
    {
        return day;
    }
    public String getMonth()
    {
        return Month;
    }
    public String getYear()
    {
        return year;
    }
}