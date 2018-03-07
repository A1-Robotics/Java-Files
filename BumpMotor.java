import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoUno;
import rxtxrobot.RXTXRobot;

public class BumpMotor {
	public static void main(String[] args)
    {    		
	    RXTXRobot r = new ArduinoUno(); //Create RXTXRobot object
		r.setPort("COM3"); // Sets the port to COM
		r.connect();
		r.refreshAnalogPins(); // Cache the Analog pin information	
		r.attachMotor(RXTXRobot.MOTOR1, 6); //attach motors
		r.attachMotor(RXTXRobot.MOTOR2, 7);
		
		int bsAnalogPin = 2;
		boolean notBumped = true;
		
		while(notBumped) { //run this loop until the sensor is bumped
			
			
			//***Should this be outside the while loop?
			r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -200, 0); //start the motors
			
			
			r.refreshAnalogPins(); 
			AnalogPin temp = r.getAnalogPin(bsAnalogPin); //get pin data
			if(temp.getValue() < 950) { //if the data dips below 950, set the boolean to false, exiting while loop
				notBumped=false;
			}
		}
		r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0); //turn off the motors
		r.close();	
    }
}