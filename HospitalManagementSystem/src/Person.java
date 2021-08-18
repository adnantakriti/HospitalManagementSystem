import java.io.Serializable;
public abstract class Person implements Serializable
{
    private String Name;
    private String age;
    private String gender;
    private String CellNum;
    private String ID;
    private Adress adress;
    public Person(String y)
    {
        Name=y;
    }
    public Person()
    {
        
    }
    public Person(String N,String p)
    {
        Name=N;
        CellNum=p;
    }
    public Person(String a,String b,String c,String d,String e,Adress f)
    {
        Name=a;
        age=b;
        gender=c;
        CellNum=d;
        ID=e;
        adress=f;
    }
    public void setName(String n)
    {
        Name=n;
    }
    public String getName()
    {
        return Name;
    }
    public void setAge(String a)
    {
        age=a;
    }
    public String getAge()
    {
        return age;
    }
    public void setGender(String g)
    {
        gender=g;
    }
    public String getGender()
    {
        return gender;
    }
    public void setCELLNUM(String c)
    {
        CellNum=c;
    }
    public String getCellnum()
    {
        return CellNum;
    }
    public void setID(String i)
    {
        ID=i;
    }
    public String getID()
    {
        return ID;
    }
    public void setAdress(Adress a)
    {
        adress=a;
    }
    public Adress getAdress()
    {
        return adress;
    }
  public void display()
  {
      System.out.println("name:"+Name);
      System.out.println("age="+age);
      System.out.println("Gender:"+gender);
      System.out.println("phone# :"+CellNum);
      System.out.println("ID :"+ID);
      System.out.println("Adress :");
      System.out.println("streetNO :"+adress.getStNo()+"house No="+adress.gethouseNo()+":"+adress.getCity());   
  }   
}