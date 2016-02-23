package xyz.sergevas.iot.bcbot.robot.common;

import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import org.apache.log4j.Logger;
import org.eclipse.californium.core.CoapServer;

import xyz.sergevas.iot.bcbot.robot.coap.RobotResource;
import xyz.sergevas.iot.bcbot.robot.route.sensor.HcSr501Route;
import xyz.sergevas.iot.bcbot.robot.route.servo.ServoRoute;

public class RobotMain {

	private static final Logger LOG = Logger.getLogger(RobotMain.class);
	
	private static final CoapServer ROBOT_COAP_SERVER = new CoapServer();

	public static void main(String[] args) {
		LOG.debug("Robot awakening...");
		
		PropertiesComponent propertiesComponent = new PropertiesComponent();
		propertiesComponent.setLocation("classpath:bcbot.properties");
		
		Main main = new Main();
		main.bind("properties", propertiesComponent);
		main.enableHangupSupport();
		main.addMainListener(new RobotManagementEvent());
		main.addRouteBuilder(new HcSr501Route());
		main.addRouteBuilder(new ServoRoute());
		try {
			main.run();
		} catch (Exception e) {
			LOG.error("Unable to awake the robot...", e);
			throw new RuntimeException("Unable to awake the robot...", e);
		}
	}
	
	public static class RobotManagementEvent extends MainListenerSupport {
		
		@Override
		public void afterStart(MainSupport main) {
			try {
				ROBOT_COAP_SERVER.add(new RobotResource("robot", main.getCamelContexts().get(0)));
				LOG.debug("Starting the robot CoAP server...");
				ROBOT_COAP_SERVER.start();
				LOG.debug("The robot CoAP server started...");
			} catch (Exception e) {
				LOG.error("Unable to configure and start the robot CoAP server...", e);
				throw new RuntimeException("Unable to configure and start the robot CoAP server...", e);
			}
		}
		
		@Override
		public void afterStop(MainSupport main) {
			super.afterStop(main);
			LOG.debug("Stopping the robot CoAP server...");
			ROBOT_COAP_SERVER.stop();
		}
	}
}
