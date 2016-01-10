package xyz.sergevas.iot.bcbot.robot.common;

import org.apache.camel.main.Main;
import org.apache.log4j.Logger;

import xyz.sergevas.iot.bcbot.robot.route.sensor.HcSr505Route;

public class RobotMain {

	private static final Logger LOG = Logger.getLogger(RobotMain.class);

	public static void main(String[] args) {
		LOG.debug("Robot awakening...");
		Main main = new Main();
		main.enableHangupSupport();
		main.addRouteBuilder(new HcSr505Route());
		try {
			main.run();
		} catch (Exception e) {
			LOG.error("Unable to awake the robot...", e);
			throw new RuntimeException("Unable to awake the robot...", e);
		}
	}
}
