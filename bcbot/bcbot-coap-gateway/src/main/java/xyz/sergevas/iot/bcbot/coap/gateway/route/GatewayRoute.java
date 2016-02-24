package xyz.sergevas.iot.bcbot.coap.gateway.route;

import static xyz.sergevas.iot.bcbot.coap.gateway.IConstants.ROBOT_MOVE_BACKWARD_ROUTE;
import static xyz.sergevas.iot.bcbot.coap.gateway.IConstants.ROBOT_MOVE_FORWARD_ROUTE;
import static xyz.sergevas.iot.bcbot.coap.gateway.IConstants.ROBOT_MOVE_TURN_LEFT_ROUTE;
import static xyz.sergevas.iot.bcbot.coap.gateway.IConstants.ROBOT_MOVE_TURN_RIGHT_ROUTE;
import static xyz.sergevas.iot.bcbot.coap.gateway.IConstants.ROBOT_STOP_ROUTE;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class GatewayRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
        restConfiguration().component("jetty")
            .host("0.0.0.0")
            .port("8080")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true");
		
        rest("/robot").description("RESTFul web-service providing access to the robot resources")
		    .put("/move/stop")
		        .consumes("application/json").produces("application/json")
		        .to(ROBOT_STOP_ROUTE)
            .put("/move/forward")
                .consumes("application/json").produces("application/json")
                .to(ROBOT_MOVE_FORWARD_ROUTE)
            .put("/move/backward")
                .consumes("application/json").produces("application/json")
	            .to(ROBOT_MOVE_BACKWARD_ROUTE)
	        .put("/move/turnright")
                .consumes("application/json").produces("application/json")
	            .to(ROBOT_MOVE_TURN_RIGHT_ROUTE)
	        .put("/move/turnleft")
                .consumes("application/json").produces("application/json")
	            .to(ROBOT_MOVE_TURN_LEFT_ROUTE);
		
		from(ROBOT_STOP_ROUTE)
		    .process(exchange -> exchange.getOut().setBody("30"));
		
		/*from("coap:localhost:5683/robot/sensor/distance/front")
		    .convertBodyTo(String.class)
		    .to("log:exch")
		    .transform(body().prepend("30"))
		    .to("log:exch");*/
	}
}

