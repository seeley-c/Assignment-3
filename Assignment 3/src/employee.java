/* **********************************************************
 * Programmer:	C. Seeley
 * Class:       CS30S
 * 
 * Assignment:	A3 Employee Payroll
 *
 * Description:	
 *
 * 
 * *************************************************************
 */
 
 // import files here as needed
 
 
 public class employee
 {  // begin class
 	
 	// *********** class constants **********
 	
            private final double OTPAYMODIFIER = 1.5;
            private final int NORMPAYHOURS = 40;
            
 	// ********** instance variable **********
            
            private static int nextID = 1000; 
            private int ID = 0;
            private double wage = 0;
            private int hours = 0;
          
     
 	// ********** constructors ***********
            
            private employee () {
                ID = nextID++;
            }
            
            private employee (int h, double w) {
                ID = nextID++;
                wage = w;
                hours = h;
                
                System.out.println(ID + ", " + wage + ", " + hours);
            }
            
            
            
 	// ********** accessors **********
            
            private double pay () {
                
               double otPay;
               double normHourPay;
               double grossPay; 
               int otHours = 0;
                
                if (hours > NORMPAYHOURS) {
                    otHours = hours - NORMPAYHOURS;
                    otPay = otHours * (wage * OTPAYMODIFIER);
                    normHourPay = (hours-otHours) * wage;
                    grossPay = normHourPay + otPay;
                }
                else {
                    grossPay = hours * wage; 
                }
                
                return grossPay;
            }
            
 	// ********** mutators **********
 
 }  // end class