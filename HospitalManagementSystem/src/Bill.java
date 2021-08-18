import java.io.Serializable;

public class Bill implements Serializable
{
    private patient patient;
    private doctor doc;
    private Room room;
    private double Totalexpenditure;
    public Bill(String f)
    {
        
    }
    public Bill(patient p,doctor d,Room r)
    {
        patient=p;
        doc=d;
        room=r;
        
    }
    public patient getPatient()
    {
        return patient;
    }
    public doctor getDoc()
    {
        return doc;
    }
    public Room getRoom()
    {
        return room;
    }
    public double getExp()
    {
        return Totalexpenditure;
    }
}
