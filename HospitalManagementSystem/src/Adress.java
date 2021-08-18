


import java.io.Serializable;
public class Adress implements Serializable{
    private String StNo;
    private String houseNo;
    private String city;
    public Adress(String a)
    {
        
    }
    public Adress(String a,String b,String c)
    {
        StNo=a;
        houseNo=b;
        city=c;
    }
    public void setCity(String x)
    {
        city=x;
    }
    public String getCity()
    {
        return city;
    }
    public void setStNo(String y)
    {
        StNo=y;
    }
    public String getStNo()
    {

        return StNo;
    }
    public void setHouseNo(String z)
    {
        houseNo=z;
    }
    public String gethouseNo()
    {
        return houseNo;
    }
    
}
