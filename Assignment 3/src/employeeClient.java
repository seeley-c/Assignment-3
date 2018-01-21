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
        String strin = "";      //input variable
        String input[] = null;  //array for splitting input
        double wage = 0;        //variable for wage
        int hours = 0;          //variable for hours
    	
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("employeeData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("A3: Employee Payroll");
        DecimalFormat df = new DecimalFormat("###.##"); //output formatting
        ArrayList<employee> employees = new ArrayList<employee>();
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString()); //output program info
        //fout.println(programInfo.toString());
        
 	    	
    // ************************ get input **********************
    
        strin = fin.readLine(); //read in first line from data file
        
        while (strin != null) { 
        //while loop for reading in data and creating new employees
            input = strin.split(delim); //split input
            
            hours = Integer.parseInt(input[0]); //parse input for hours
            wage = Double.parseDouble(input[1]); //parse input for wage
                        
            employees.add(new employee(hours, wage)); //add employee to array list
            
            strin = fin.readLine(); //read in next line
        }//end while
            
    // ************************ processing ***************************
    
        
    // ************************ print output ****************************
    
        System.out.println("There are " + employees.size() + " employees"); 
            //outputs the number of employees 
        
        for(employee i: employees) //output data for each employee
            System.out.println(i);
        
        System.out.println("\nEmployee 1's ID is: " + employees.get(0).getID());
        System.out.println("Employee 2's normal pay is: $" + df.format(employees.get(1).getNormHourPay()));
        System.out.println("Employee 3's overtime pay is: $" + df.format(employees.get(2).getOTPay()));
        System.out.println("Employee 4's gross pay is: $" + df.format(employees.get(3).pay()));
        System.out.println("Employee 5's hours are: " + employees.get(4).getHours() + "\n");
            //output different data for each employee
    
        // ******** closing message *********
        
        System.out.println(programInfo.eoFile());
        fout.println(programInfo.eoFile());
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class

