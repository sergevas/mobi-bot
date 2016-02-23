package xyz.sergevas.iot.bcbot.robot.coap;

import static java.lang.String.format;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_STOP_ROUTE;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.apache.log4j.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import xyz.sergevas.iot.bcbot.robot.common.RobotMove;

public class StopResource extends CoapResource {
	
	private static final Logger LOG = Logger.getLogger(StopResource.class);
	
	private RobotMove robotMove;

	public StopResource(String name, CamelContext camelContext) throws Exception {
		super(name);
		robotMove = new ProxyBuilder(camelContext).endpoint(ROBOT_STOP_ROUTE).build(RobotMove.class);
	}
	
	@Override
	public void handlePUT(CoapExchange exchange) {
		LOG.debug(format("Start handlde PUT for CoapExchange with a text[%s]", exchange.getRequestText()));
		LOG.debug("Start Calling Camel route to stop the robot...");
		robotMove.move(null);
		LOG.debug("The robot should be stopped...");
		exchange.respond(CHANGED);
	}
}
