package clinic;

 

import java.util.ArrayList;

import java.util.Date;

import java.util.Scanner;




public class Doctor {
    
//Attributes
   private int doctorId;
   private String doctorName;
   private String phoneNumber; 
   private String specialization;
   private double fees;
   
   private char[][] status; // A: Available  N: Not avail
   private ArrayList <String> schedule = new ArrayList();
   private ArrayList  <String> bookings = new ArrayList();
   

   //Constructor 
     public Doctor(int doctorId, String doctorName, String phoneNumber,String specialization, double fees)

    {

       this.doctorId = doctorId ;
       this.specialization = specialization;
       this.doctorName = doctorName;         
       this.fees = fees; 
       this.phoneNumber = phoneNumber;
       this.status = new char[6][6];
        for(int i = 0; i < 6 ; i++){
            
                for(int j = 0; j<6; j++){
                    this.status[i][j]='N';
                }
        }

    }

 

 

//Methods
     public void setSchedule(int day, int time) { 
        
        String [] D = new String [6]; 
        D[0] = "Saturday"; 
        D[1] = "Sunday"; 
        D[2] = "Monday"; 
        D[3] = "Tuesday"; 
        D[4] = "Wedensday"; 
        D[5] = "Thursday"; 
        String [] t = new String[6]; 
        t [0] = "9-11";
        t [1] = "11-1";
        t [2] = "1-3";
        t [3] = "3-5";
        t [4] = "5-7";
        t [5] = "7-9";
    
        
        String temp =  D[day] + t[time]; 
        
        // check if slot already exist
        if(schedule.contains(temp)==true){
            System.out.println("time aleady there");
        }
        else{
            schedule.add(temp); 
            this.status [day][time] = 'A'; 
        }
    }
     public void removeSchedule(int day, int time){
        String [] D = new String [6]; 
        D[0] = "Saturday"; 
        D[1] = "Sunday"; 
        D[2] = "Monday"; 
        D[3] = "Tuesday"; 
        D[4] = "Wedensday"; 
        D[5] = "Thursday"; 
        String [] t = new String[6]; 
        t [0] = "9-11";
        t [1] = "11-1";
        t [2] = "1-3";
        t [3] = "3-5";
        t [4] = "5-7";
        t [5] = "7-9";
    
        
        String temp =  D[day] + t[time]; 
        
        if(schedule.contains(temp)==true){
            schedule.remove(temp);
            this.status [day][time] = 'N'; 

        }
        else{
            System.out.println("No slot to remove");
        }
     }
    
     public void book(int day, int time){
     
         String [] D = new String [6]; 
        D[0] = "Saturday"; 
        D[1] = "Sunday"; 
        D[2] = "Monday"; 
        D[3] = "Tuesday"; 
        D[4] = "Wedensday"; 
        D[5] = "Thursday"; 
        String [] t = new String[6]; 
        t [0] = "9-11";
        t [1] = "11-1";
        t [2] = "1-3";
        t [3] = "3-5";
        t [4] = "5-7";
        t [5] = "7-9";
    
        
        String temp =  D[day] + t[time]; 
        
        // .add String if not a;ready there 
        if(schedule.contains(temp)==true){
            bookings.add(temp);
            schedule.remove(temp);
           this.status[day][time] = 'N';
        }
        else{
               
        }
        
     }
     public void cancelBook(int day, int time){
         
         String [] D = new String [6]; 
        D[0] = "Saturday"; 
        D[1] = "Sunday"; 
        D[2] = "Monday"; 
        D[3] = "Tuesday"; 
        D[4] = "Wedensday"; 
        D[5] = "Thursday"; 
        String [] t = new String[6]; 
        t [0] = "9-11";
        t [1] = "11-1";
        t [2] = "1-3";
        t [3] = "3-5";
        t [4] = "5-7";
        t [5] = "7-9";
    
        
        String temp =  D[day] + t[time]; 
        
        // .add String if not a;ready there 
        if(schedule.contains(temp)!=true){
            schedule.add(temp);
            bookings.remove(temp);
           this.status[day][time] = 'A';
        }
        else{
               
        }
     }
     public void viewRevenue(){
       double r = bookings.size()*fees; 
         System.out.println(r);
     }
      public void viewBooked(){
        
        System.out.println(bookings);

       }
     
     @Override
     public String toString () {        

        return "Doctor ID: "+doctorId+", Doctor name: "+doctorName;        

    }  

   
    

//Setters and Getters
     public void setFees(double x){
         this.fees = x; 
     }
     public double getFees(){
         return fees;
     }
    public void setId (int doctorId) {            

        this.doctorId = doctorId;        

    }
    public void setName (String doctorName) {        

        this.doctorName = doctorName;        

    }
    public int getId (){        

        return doctorId;        

    }
    public String getName () {        

        return doctorName;            

    }  

    public ArrayList<String> getSchedule() {
        return schedule;
    }
    
    
     public char getStatus(int x, int y){
         return status[x][y]; 
    }

    public String getSpecialization() {
        return specialization;
    }
    
  
   
}