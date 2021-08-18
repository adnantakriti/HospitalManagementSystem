
    import java.io.Serializable;
public class Time implements Serializable {
    private String hour;
    private String min;
    private String sec;
   public Time(String x)
   {
       
   }
    public Time(String a,String b,String c)
    {
        hour=a;
        min=b;
        sec=c; 
    }
    public String getMin()
    {
        return min;
    }
    public String getSec()
    {
        return sec;
    }
    public String getHour()
    {
        return hour;
    }
}