package clinic; 


import java.util.ArrayList;

public class Main{
    
        public ArrayList <Patient> pObject = new ArrayList(); 

    public ArrayList <Doctor> dObject = new ArrayList(); 
    public static void main(String[] args) {
        
        
        Patient noeman = new Patient(123,"Noeman","011569");//test
        
        Login test = new Login(); 
        test.show();
        
    }
    
}