/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 2
 * Program Name:  name of public class
 *
 * Description: brief description of program
 *
 * Input: data to be input
 *
 * Output: results to be output
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
 

public class A2Client {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
        int MAX = 10;
    
    // ********** declaration of variables **********
    	
    	String delim = "[ ]+";		// delimiter string for splitting input string
        String strin = "";
        String input[] = null;
        int n = 0;
        int timesInt[] = new int[MAX];
        double averageTime = 0;
        double singleSpeed = 0;
        int singleTime = 0;
        
        
    	
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("skaterData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("Assignment 2");
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString());
        //fout.println(programInfo.toString());
        
 	    	
    // ************************ get input **********************
        
    
    
        strin = fin.readLine();
        
        while(strin != null){
            int j = 0;
            input = strin.split(delim);
            
            A2Class skater = new A2Class(n, input);
          
            for(int i = 0; i < input.length; i++){
                timesInt[n] = skater.singleTime(input[i], j);
                
                singleSpeed = skater.singleSpeed(timesInt[n]);
                
                
                System.out.println("Time: " + input[i]);
                //System.out.println("Time: " + timesInt[n]);
                System.out.println(singleSpeed + "Km/h\n");
                j++;
            } // end for tokens
            
            averageTime = skater.avgTime();
            //System.out.println(averageTime + "\n");
            
          //System.out.println(strin);
          n++;
          strin = fin.readLine();
        } // end eof loop
    	

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
