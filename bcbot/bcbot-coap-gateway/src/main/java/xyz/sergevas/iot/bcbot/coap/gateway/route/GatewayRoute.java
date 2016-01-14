package xyz.sergevas.iot.bcbot.coap.gateway.route;

import org.apache.camel.builder.RouteBuilder;

public class GatewayRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
        restConfiguration("coap").host("localhost").port(5683);
		rest("/robot/sensor/distance/front")
		    .get()
		    .to("direct:robotSensorDistanceFront");
		
		from("direct:robotSensorDistanceFront")
		    .process(exchange -> exchange.getOut().setBody("30"));
		
		/*from("coap:localhost:5683/robot/sensor/distance/front")
		    .convertBodyTo(String.class)
		    .to("log:exch")
		    .transform(body().prepend("30"))
		    .to("log:exch");*/
	}
}
