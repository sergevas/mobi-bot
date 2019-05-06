package xyz.sergevas.iot.bcbot.robot.entity;

public interface Vehicle {

	void moveForward(int speed);
	
	void moveBackward(int speed);
	
	void stop();
	
	void turnRight(double radians);
	
    void turnLeft(double radians);	
}
