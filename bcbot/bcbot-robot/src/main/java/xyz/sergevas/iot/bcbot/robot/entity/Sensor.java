package xyz.sergevas.iot.bcbot.robot.entity;

public interface Sensor<E extends SensorEvent> {
	
	public void handle(E event);
}
