package clinic;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Objects;

/**
 *
 * @author Noeman
 */
public class Booking {
  //Attributes
    private static int code; 
    private String docName; 
    private String patName;
    private double fees;
    private int day;
    private int time;
    private String dtDetails; 

    public Booking(String docName, String patName, int day, int time, double f ) {
        this.docName = docName;
        this.patName = patName;
        this.fees = f;
        this.code++; 
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
        
        this.dtDetails =  D[day] + t[time]; 
        
    }
    
//Methods
    
// Setters And Getters
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

     public String getdtDetails() {
        return dtDetails;
    }

    public int getDay() {
        return day;
    }

    public int getTime() {
        return time;
    }

    public static int getCode() {
        return code;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.docName, other.docName)) {
            return false;
        }
        if (!Objects.equals(this.patName, other.patName)) {
            return false;
        }
        return Objects.equals(this.dtDetails, other.dtDetails);
    }

    
    
}
