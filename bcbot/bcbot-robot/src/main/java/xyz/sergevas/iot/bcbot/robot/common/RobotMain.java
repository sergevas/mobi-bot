package xyz.sergevas.iot.bcbot.robot.common;

import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.main.Main;
import org.apache.log4j.Logger;
//import org.eclipse.californium.core.CoapServer;

import xyz.sergevas.iot.bcbot.robot.route.sensor.CoAPMockRoute;
import xyz.sergevas.iot.bcbot.robot.route.sensor.HcSr501Route;

public class RobotMain {

	private static final Logger LOG = Logger.getLogger(RobotMain.class);

	public static void main(String[] args) {
		LOG.debug("Robot awakening...");
//		CoapServer coapServer = new CoapServer();
//		coapServer.add(resources);
		
		PropertiesComponent propertiesComponent = new PropertiesComponent();
		propertiesComponent.setLocation("classpath:bcbot.properties");
		
		Main main = new Main();
		main.bind("properties", propertiesComponent);
		main.enableHangupSupport();
		
		main.addRouteBuilder(new HcSr501Route());
		main.addRouteBuilder(new CoAPMockRoute());
		try {
			main.run();
		} catch (Exception e) {
			LOG.error("Unable to awake the robot...", e);
			throw new RuntimeException("Unable to awake the robot...", e);
		}
	}
}
