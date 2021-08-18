import java.io.Serializable;
public class doctor extends Person implements Serializable{
    private String specialization;
    private String fee;
    public doctor(String x)
    {
        super(x);
   
    }
    public doctor(String x,String b)
    {
        super(x,b);
    }
    public doctor(String a,String b,String c,String d,String e,Adress f,String x,String y)
    {
        super(a,b,c,d,e,f);
        specialization=x;
        fee=y;
  
    }
    public String getSpecialization()
    {
        return specialization;
    }
    public String getfee()
    {
        return fee;
   }  
}

    