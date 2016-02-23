package xyz.sergevas.iot.bcbot.robot.coap;

import org.apache.camel.CamelContext;
import org.eclipse.californium.core.CoapResource;

public class RobotResource extends CoapResource {
	
	public RobotResource(String name, CamelContext camelContext) throws Exception {
		super(name);
		super.add(new MoveResource("move", camelContext));
	}
}
