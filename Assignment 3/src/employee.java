
import java.text.DecimalFormat;

/* **********************************************************
 * Programmer:	C. Seeley
 * Class:       CS30S
 * 
 * Assignment:	A3 Employee Payroll
 *
 * Description:	overrides toString, calculates pay when given 
 *              hours and wage, returns data for employee, 
 *              creates unique id for employee
 *
 * 
 * *************************************************************
 */
 
 // import files here as needed
 
 
 public class employee
 {  // begin class
 	
 	// *********** class constants **********
 	
            private final double OTPAYMODIFIER = 1.5; //final int for overtime modifier
            private final int NORMPAYHOURS = 40; //final int for normal pay hours
            
 	// ********** instance variable **********
            
            private static int nextID = 1000; //static int for id
            private int ID = 0; //int for id
            private double wage = 0; //int for wage
            private int hours = 0; //int for hours
            private double otPay = 0; //int overtime pay
            private double normHourPay = 0; //int for normal pay
          
     
 	// ********** constructors ***********
            
            /********************************************************
            * Purpose:        Default constructor with no wage or 
            *                 hours
            *         
            * Interface:
            *     in:         None
            *     out:        None
            ********************************************************/
            public employee () {
                ID = nextID++;
            }//end default constructor
            
            /********************************************************
            * Purpose:        Constructor that is provided wage and 
            *                 hours
            *         
            * Interface:
            *     in:         Wage and hours
            *     out:        None
        ********************************************************/
            public employee (int h, double w) {
                ID = nextID++;
                wage = w;
                hours = h;
            }//end initialized constructor
            
            
 	// ********** accessors **********
            
            /********************************************************
            * Purpose:        Return ID of employee
            *         
            * Interface:
            *     in:         None
            *     out:        ID
            ********************************************************/
            public int getID () {
                return ID;
            }//end getID
            
            /********************************************************
            * Purpose:        Return wage of employee
            *         
            * Interface:
            *     in:         None
            *     out:        wage
            ********************************************************/
            public double getWage() {
                return wage;
            }//end getWage
            
            /********************************************************
            * Purpose:        Return hours of employee
            *         
            * Interface:
            *     in:         None
            *     out:        hours
            ********************************************************/
            public int getHours() {
                return hours;
            }//end getHours
            
            /********************************************************
            * Purpose:        Return gross pay of employee
            *         
            * Interface:
            *     in:         None
            *     out:        gross pay
            ********************************************************/
            public double pay () {
                
               double grossPay; //variable for gross pay
               int otHours = 0; //variable for overtime hours
                
                if (hours > NORMPAYHOURS) { //if employee has worked overtime
                    otHours = hours - NORMPAYHOURS; //overtime hours calculation
                    otPay = otHours * (wage * OTPAYMODIFIER); //calculate overtime pay
                    normHourPay = (hours-otHours) * wage; //calculate normal pay
                    grossPay = normHourPay + otPay; //calculate gross pay
                }//end if
                else { //if employee has not worked overtime
                    normHourPay = hours * wage; //calculate pay
                    grossPay = normHourPay;
                }//end else
                
                
                return grossPay; //return pay
            }//end pay
            
            /********************************************************
            * Purpose:        Return overtime pay of employee
            *         
            * Interface:
            *     in:         None
            *     out:        Overtime pay
            ********************************************************/
            public double getOTPay () {
                double otPay = 0; //variable for overtime pay
                int otHours = hours - NORMPAYHOURS; //calculate overtime hours
                
                otPay = otHours * (wage * OTPAYMODIFIER); //calculate overtime pay
                
                return otPay; //return overtime pay
            }//end getOTPay
            
            /********************************************************
            * Purpose:        Return normal pay of employee
            *         
            * Interface:
            *     in:         None
            *     out:        Normal pay
            ********************************************************/
            public double getNormHourPay () {
                int normHour = 0; //variable for normal hours
                int otHours = hours - NORMPAYHOURS; //variable for overtime hours
                
                normHour = hours - otHours; //calculate normal hours
                normHourPay = normHour * wage; //calculate normal hour pay
                
                return normHourPay; //return normal pay
            }//end getNormHourPay
            
            /********************************************************
            * Purpose:        Override toString() function and return
            *                 employee's id, hours, wage, normal pay, 
            *                 overtime pay, and gross pay
            *         
            * Interface:
            *     in:         None
            *     out:        Data string
            ********************************************************/
            public String toString(){
                String data = ""; //variable for employee data
                DecimalFormat df = new DecimalFormat("###.##"); //output format
                
                data = ("Employee: " + (this.getID()) + "\t");
                data += ("Hours: " + this.getHours() + "\t");
                data += ("Wage: " + this.getWage() + "\t");
                data += ("Normal Hour Pay: $" + df.format(this.getNormHourPay()) + "\t");
                data += ("Overtime Pay: $" + df.format(this.getOTPay()) + "\t");
                data += ("Gross Pay: $" + df.format(this.pay()) + "\t");
                
                return data; //return data
            }//end toString
            
 	// ********** mutators **********
 
 }  // end class