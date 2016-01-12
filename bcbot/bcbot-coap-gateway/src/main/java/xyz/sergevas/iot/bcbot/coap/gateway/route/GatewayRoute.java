package xyz.sergevas.iot.bcbot.coap.gateway.route;

import org.apache.camel.builder.RouteBuilder;

public class GatewayRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("coap:localhost:5683/robot/sensor/distance/front")
		    .convertBodyTo(String.class)
		    .to("log:exch")
		    .transform(body().prepend(30))
		    .to("log:exch");
	}
}
