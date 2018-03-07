

import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoUno;
import rxtxrobot.RXTXRobot;

public class Thermometer {
	public static void main(String[] args)
    {    		
	    RXTXRobot r = new ArduinoUno(); //Create RXTXRobot object
		r.setPort("COM3"); // Sets the port to COM
		r.connect();
		r.refreshAnalogPins(); // Cache the Analog pin information	
		
		int thermoAnalogPin = 1; //this is the long red and black thermister
		 
		int datapoints = 10;
		int[] rawData = new int[datapoints]; 
		int rawTotal = 0;
		
		for (int c = 0; c < datapoints; c++) {
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(thermoAnalogPin); //get pin data
			rawData[c] = temp.getValue();
			rawTotal = rawTotal + rawData[c];
			System.out.println(c + 1 + "\t" + rawData[c]);
			r.sleep(100);
		}
    
		double rawAvg = (double) rawTotal / (double) datapoints;
		System.out.println("The probe read the value: " + rawAvg);
		System.out.println("In volts: " + (rawAvg * (5.0/1023.0)));
		r.close();	
		
		double slope = -11.05667506;
		double intercept = 3827.700252;
		double temp = ((rawAvg - intercept)/slope)-273;
		System.out.println();
		System.out.println("It is " + temp + " degrees Celsius");
    }
}
