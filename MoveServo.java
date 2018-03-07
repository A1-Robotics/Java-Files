// This example moves each servo individually.  While this method should be used to move one servo individually, it is recommended to use moveBothServos if both servos must be moved simultaneously
import rxtxrobot.*;

public class MoveServo
{
	public static void main(String[] args)
	{
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object
		r.setPort("COM3"); // Set the port to COM3
		r.setVerbose(true); // Turn on debugging messages
		r.connect();
		r.attachServo(RXTXRobot.SERVO1, 5); //Connect the servos to the Arduino
		r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to location 30
		r.sleep(2000);
		r.moveServo(RXTXRobot.SERVO1, 180); // Move Servo 1 to location 30
		r.sleep(2000);
		r.close();
	}
}
