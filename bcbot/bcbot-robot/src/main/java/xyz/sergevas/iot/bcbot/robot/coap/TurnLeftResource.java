package xyz.sergevas.iot.bcbot.robot.coap;

import static java.lang.String.format;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_MOVE_TURN_LEFT_ROUTE;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.apache.log4j.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import xyz.sergevas.iot.bcbot.robot.common.RobotMove;

public class TurnLeftResource extends CoapResource {
	
private static final Logger LOG = Logger.getLogger(ForwardResource.class);
	
	private RobotMove robotMove;

	public TurnLeftResource(String name, CamelContext camelContext) throws Exception {
		super(name);
		robotMove = new ProxyBuilder(camelContext).endpoint(ROBOT_MOVE_TURN_LEFT_ROUTE).build(RobotMove.class);
	}
	
	@Override
	public void handlePUT(CoapExchange exchange) {
		LOG.debug(format("Start handlde PUT for CoapExchange with text [%s]", exchange.getRequestText()));
		String robotSpeedMode = exchange.getRequestText();
		LOG.debug(format("Start Calling Camel route to turn the robot left with speed mode [%s]", robotSpeedMode));
		robotMove.move(robotSpeedMode);
		LOG.debug("End calling Camel route...");
		exchange.respond(CHANGED);
	}
}
