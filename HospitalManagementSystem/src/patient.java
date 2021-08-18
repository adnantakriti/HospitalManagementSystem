import java.io.Serializable;


public class patient extends Person implements Serializable
{
   private date DateOfAdmission;
    private Room Room;
    private doctor DoctorConsulted;
    private Medicine medicine;
    private Bill bill;
    public patient(String a,String b)
    {
        super(a,b);
    }
  public patient(String a,String b,String c,String d,String e,Adress f,date y,Room r,doctor x,Medicine m,Bill z)
  {
      super(a,b,c,d,e,f);
      DateOfAdmission=y;
      Room=r;
      DoctorConsulted=x;
      medicine=m;
      bill=z;
  }
  public void setDOA(date x)
  {
      DateOfAdmission=x;
  }
  public date getDOA()
  {
      return DateOfAdmission;
  }
  public void setRoom(Room r)
  {
      Room=r;
  }
  public Room getRoom()
  {
      return Room;
  }
  public void setDoc(doctor y)
  {
      DoctorConsulted=y;
  }
  public doctor getconsultedDoc()
  {
      return DoctorConsulted;
  }
  public void setMed(Medicine z)
  {
      medicine=z;
  }
  public Medicine getmedicine()
  {
      return medicine;
  }
  public void setBill(Bill b )
  {
      bill=b;
  }
  public Bill getBill()
  {
      return bill;
  }
}

