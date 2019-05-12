package xyz.sergevas.iot.mobibot.robot.entity;

import java.util.function.Consumer;

public interface Sensor<S, T extends SensorEvent<T>> {
	
	void handle();
	
	void notify(Consumer<S> callback);
	
	SensorEvent<T> getEvent();
}
