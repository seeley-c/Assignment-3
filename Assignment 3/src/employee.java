
import java.text.DecimalFormat;

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
            private double pay = 0;
            private double otPay = 0;
            private double normHourPay = 0;
          
     
 	// ********** constructors ***********
            
            public employee () {
                ID = this.getID();
            }
            
            public employee (int h, double w) {
                ID = this.getID();
                wage = w;
                hours = h;
            }
            
            
            
 	// ********** accessors **********
            
            public int getID () {
                int id = 0;
                id = nextID; 
                return id;
            }
            
            public double pay () {
                
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
                    normHourPay = grossPay;
                }
                
                pay = grossPay;
                
                return grossPay;
            }
            
            public double getOTPay () {
                double otPay = 0;
                int otHours = hours - NORMPAYHOURS;
                
                otPay = otHours * (wage * OTPAYMODIFIER);
                
                return otPay;
            }
            
            public double getNormHourPay () {
                int normHour = 0;
                int otHours = hours - NORMPAYHOURS;
                
                normHour = hours - otHours;
                normHourPay = normHour * wage;
                
                return normHourPay;
            }
            
            public String toString(){
                String data = "";
                DecimalFormat df = new DecimalFormat("###.##");
                
                data = ("Employee: " + ID + "\t");
                data += ("Hours: " + hours + "\t");
                data += ("Wage: " + wage + "\t");
                data += ("Normal Hour Pay: $" + df.format(this.getNormHourPay()) + "\t");
                data += ("Overtime Pay: $" + df.format(this.getOTPay()) + "\t");
                data += ("Gross Pay: $" + df.format(this.pay()) + "\t");
                
                return data;
            }
            
 	// ********** mutators **********
 
 }  // end class