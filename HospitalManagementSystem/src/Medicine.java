import java.io.Serializable;

public class Medicine implements Serializable{
    private String medicines;
    private int Mcharges;
    public Medicine(String g)
    {
        
    }
    public Medicine(String x,int y)
    {
        medicines=x;
        Mcharges=y;
    }
    public String getmed()
    {
        return medicines;
    }
    public int getcharges()
    {
        return Mcharges;
}
}

