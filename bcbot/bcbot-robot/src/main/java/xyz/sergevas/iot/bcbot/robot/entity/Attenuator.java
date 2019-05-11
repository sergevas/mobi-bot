package xyz.sergevas.iot.bcbot.robot.entity;

public interface Attenuator<E extends Command> {
    public void execute(E e);
}
