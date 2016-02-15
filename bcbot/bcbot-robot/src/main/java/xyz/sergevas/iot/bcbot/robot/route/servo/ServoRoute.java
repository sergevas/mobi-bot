package xyz.sergevas.iot.bcbot.robot.route.servo;

import org.apache.camel.builder.RouteBuilder;

public class ServoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:robot.move.forward").choice().
	}
}
