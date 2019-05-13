package xyz.sergevas.iot.mobibot.robot.bounadry;

import jdk.dio.DeviceConfig;
import jdk.dio.gpio.GPIOPinConfig;
import xyz.sergevas.iot.mobibot.robot.entity.Attenuator;
import xyz.sergevas.iot.mobibot.robot.entity.Command;

public class RobotStateLED implements Attenuator {
	
	private GPIOPinConfig ledPinConfig;
	
	

	public RobotStateLED() {
		this.ledPinConfig = new GPIOPinConfig.Builder()
				.setControllerNumber(DeviceConfig.UNASSIGNED)
				.setPinNumber(17)
				.setDirection(GPIOPinConfig.DIR_OUTPUT_ONLY)
				.setTrigger(GPIOPinConfig.TRIGGER_NONE)
				.setDriveMode(GPIOPinConfig.MODE_OUTPUT_PUSH_PULL)
				.setInitValue(false)
				.build();
	}

	@Override
	public <T extends Command> void execute(T t) {
	}
}

