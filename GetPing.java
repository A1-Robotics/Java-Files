import rxtxrobot.*;

public class GetPing
{
	final private static int PING_PIN = 4;

	public static void main(String[] args)
	{
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object
		r.setPort("COM3"); // Set the port to COM3
		r.connect();
		
		int datapoints = 10;
		int[] rawData = new int[datapoints]; 
		int rawTotal = 0;
		
		for (int c = 0; c < datapoints; c++) {
			rawData[c] = r.getPing(PING_PIN);
			rawTotal = rawTotal + rawData[c];
//			System.out.println((c + 1) + "\t" + rawData[c]);
			r.sleep(50);
		}
		double rawAvg = (double) rawTotal / (double) datapoints;
		System.out.println();
		System.out.println("Distance measured: " + rawAvg);
		r.close();
	}
}
