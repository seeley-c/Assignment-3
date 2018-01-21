/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 3 Employee Payroll
 * Program Name:  employeeClient
 *
 * Description: 
 *
 * Input: 
 *
 * Output: 
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.ArrayList;
 

public class employeeClient {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
        final double OVERTIME = 1.5;
    
    // ********** declaration of variables **********
    	
    	String delim = "[ ]+";		// delimiter string for splitting input string
        String strin = "";
        String input[] = null;
        double wage = 0;
        int hours = 0;
        double pay = 0;
        
        String output = "";
        ArrayList<employee> employees = new ArrayList<employee>();
        
    	
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("employeeData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("A3: Employee Payroll");
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString());
        //fout.println(programInfo.toString());
        
 	    	
    // ************************ get input **********************
        
        int n = 0;
    
        strin = fin.readLine();
        
        while (strin != null) {
            input = strin.split(delim);
            
            hours = Integer.parseInt(input[0]);
            wage = Double.parseDouble(input[1]);
                        
            employees.add(new employee(hours, wage));
            
            strin = fin.readLine();
        }
            
    // ************************ processing ***************************
    
        System.out.println("There are " + employees.size() + " employees");
        
        for(employee i: employees)
            System.out.println(i);
        
        
    // ************************ print output ****************************

    
        // ******** closing message *********
        
        System.out.println(programInfo.eoFile());
        fout.println(programInfo.eoFile());
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class

