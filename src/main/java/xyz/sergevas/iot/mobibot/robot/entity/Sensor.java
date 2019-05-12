package xyz.sergevas.iot.mobibot.robot.entity;

public interface Sensor<E extends SensorEvent> {
	
	public void handle(E event);
}
