package xyz.sergevas.iot.bcbot.robot.route.sensor;

import org.apache.camel.builder.RouteBuilder;

public class CoAPMockRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration("coap").host("localhost").port(5683);
		rest("/robot/sensor/distance/front")
		    .get()
		    .to("direct:robotSensorDistanceFront");
		
		from("direct:robotSensorDistanceFront")
		    .process(exchange -> exchange.getOut().setBody("30"));
	}
}
