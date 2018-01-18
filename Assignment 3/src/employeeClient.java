/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 3
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
        
        
    	
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("employeeData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("Assignment 2");
        
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString());
        //fout.println(programInfo.toString());
        
 	    	
    // ************************ get input **********************
        
    
    
        strin = fin.readLine();
        
        while (strin != null) {
            input = strin.split(delim);
            
            hours = Integer.parseInt(input[0]);
            wage = Double.parseDouble(input[1]);
            
            employee Employee = new employee(hours, wage);
            
            strin = fin.readLine();
        }
        
        
    	

    // ************************ processing ***************************
    
    // ************************ print output ****************************

    
        // ******** closing message *********
        
        System.out.println(programInfo.eoFile());
        fout.println(programInfo.eoFile());
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class

