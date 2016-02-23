package xyz.sergevas.iot.bcbot.robot.coap;

import org.apache.camel.CamelContext;
import org.eclipse.californium.core.CoapResource;

public class MoveResource extends CoapResource {

	public MoveResource(String name, CamelContext camelContext) throws Exception {
		super(name);
		super.add(
				new StopResource("stop", camelContext),
				new ForwardResource("forward", camelContext),
				new BackwardResource("backward", camelContext),
				new TurnRightResource("turnright", camelContext),
				new TurnLeftResource("turnleft", camelContext));
	}
}
