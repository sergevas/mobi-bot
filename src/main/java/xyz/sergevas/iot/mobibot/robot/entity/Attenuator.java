package xyz.sergevas.iot.mobibot.robot.entity;

public interface Attenuator<E extends Command> {
    public void execute(E e);
}
