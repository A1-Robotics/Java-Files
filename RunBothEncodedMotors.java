import rxtxrobot.*;

public class RunBothEncodedMotors
{
	public static void main(String[] args)
	{
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object
		r.setPort("COM3"); // Set port to COM3
		r.connect();
		r.refreshAnalogPins();
		r.attachMotor(RXTXRobot.MOTOR1, 6); //left motor  attach motors
		r.attachMotor(RXTXRobot.MOTOR2, 7); //right motor
		r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -200, 0); // Run both motors forward indefinitely
		r.sleep(7700); // Pause execution for 7700 ticks, but the motors keep running.
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors
		r.close();
	}
}