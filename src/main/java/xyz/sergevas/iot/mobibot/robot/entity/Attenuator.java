package xyz.sergevas.iot.mobibot.robot.entity;

public interface Attenuator {
	
    <T extends Command> void execute(T t);
}
