import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoUno;
import rxtxrobot.RXTXRobot;

public class Windometer {
	public static void main(String[] args)
    {    		
	    RXTXRobot r = new ArduinoUno(); //Create RXTXRobot object
		r.setPort("COM3"); // Sets the port to COM
		r.connect();
		r.refreshAnalogPins(); // Cache the Analog pin information	
		
		int thermoAnalogPin = 1;
		int windAnalogPin = 0;
		 
		int Totaltemp1 = 0;
		int Totaltemp2 = 0;
		
		int datapoints = 10;
		for (int c = 0; c < datapoints; c++) {
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(windAnalogPin); //get pin data
			AnalogPin temp2 = r.getAnalogPin(thermoAnalogPin); //get pin data
			
			Totaltemp1 = Totaltemp1 + temp.getValue();
			Totaltemp2 = Totaltemp2 + temp2.getValue();
			
			r.sleep(500);
		}
    
		double Avgtemp1 = Totaltemp1 / datapoints;
		double Avgtemp2 = Totaltemp2 / datapoints;
		
		System.out.println("Input 1 = " + Avgtemp1);
		System.out.println("Input 2 = " + Avgtemp2);
		System.out.println("Difference = " + (Avgtemp1 - Avgtemp2));
		r.close();	
    }
}
