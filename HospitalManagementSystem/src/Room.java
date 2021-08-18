import java.io.Serializable;
public class Room implements Serializable{
    private String RoomNum;
    private String RoomType;
    private String RoomCharges;
    public Room(String z)
    {
        
    }
    public Room(String a,String b,String c)
    {
        RoomNum=a;
        RoomType=b;
        RoomCharges=c;
    }
   
    public String getRoomNum()
    {
        return RoomNum;
    }
  
    public String getRoomType()
    {
        return RoomType;
    }
   
    public String getCharges()
    {
        return RoomCharges;
    }
}

