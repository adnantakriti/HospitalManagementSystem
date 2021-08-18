



import java.io.Serializable;
public class Appointment implements Serializable {
   private patient patient;
   private doctor doctor;
   private String appointmentNum;
   private Time appointmentTime;
   private date appointmentDate;
   public Appointment(String d)
   {
       
   }
   public Appointment(patient p,doctor d,String x,Time t,date y)
   {
       patient=p;
       doctor=d;
       appointmentNum=x;
       appointmentTime=t;
       appointmentDate=y;  
    }
}

    

