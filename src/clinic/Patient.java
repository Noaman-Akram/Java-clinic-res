package clinic;

 

 

import java.util.ArrayList;
import java.util.Date;

 

public class Patient {

    //Attributes
   private int patientId;   
   private String username; 
   private String password; 
   private String patientName;
   private String phoneNumber; 
   private char[][] status; //R: Reserved  A: Available  
   private ArrayList <String> appointments = new ArrayList(); 
   private ArrayList <String> Cappointments = new ArrayList(); 
    
   //Constructor
   public Patient(int patientId, String patientName, String phoneNumber)
    {

        // initialise instance variables

        this.patientId = patientId;

        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        
        this.username = patientName + patientId; 
        this.password = ""; 
        this.status = new char[6][6];
        for(int i = 0; i < 6 ; i++){
            
                for(int j = 0; j<6; j++){
                    this.status[i][j]='A';
                }
        }
        
    }
//Methods
   public void Browse(Doctor x){
       System.out.println(x.getName());
       System.out.println(x.getSchedule());
   }
   public void Book(Doctor d, int date, int time){
      
      if(d.getStatus(date, time)=='A'){
          if(this.status[date][time]=='A'){
          d.book(date, time);
       Booking t= new Booking(d.getName(), patientName, date, time,d.getFees());
       //Booking t1= new Booking(d.getName(), patientName, 2, time,d.getFees());
       this.status[date][time] = 'R'; 
       Cappointments.add(t.getdtDetails());
       appointments.add(d.getName()+" : "+t.getdtDetails()+ ",Fees: " + d.getFees());
              System.out.println("Booked! code : " + t.getCode());
             // System.out.println(t.equals(t1));
          }
          else{
              System.out.println("Patient reserved that time");
          }
          }
      else{
          System.out.println("Doctor isnt available");
      }
   }
   public void cancelBook(Doctor d, int date, int time){
       if(d.getStatus(date, time)=='N'){
           if(this.status[date][time]=='R'){
               d.cancelBook(date, time);
               Booking t = new Booking(d.getName(),patientName,date,time,d.getFees());
               
               this.status[date][time]='A'; 
               Cappointments.remove(t.getdtDetails());
               appointments.remove(d.getName()+" : "+t.getdtDetails()+ ",Fees: " + d.getFees()); 
          }
           else{
               System.out.println("Patient isnt resereved!");
           }
          
       }
       else{
           System.out.println("Doctor isnt resereved to cancel!");
       }
   }

    public void viewBooked() {
        
        System.out.println(appointments);
    }
  
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Setters and Getters
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId () {

 

           return patientId;

 

    }
    public String getName () {

 

            return patientName;  

 

    }
    public char getStatus(int x, int y){
         return status[x][y]; 
    }
   
    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", username=" + username + ", password=" + password + ", patientName=" + patientName + ", appointments=" + appointments + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getAppointments() {
        return appointments;
    }

    public ArrayList<String> getCappointments() {
        return Cappointments;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

 
 

}    