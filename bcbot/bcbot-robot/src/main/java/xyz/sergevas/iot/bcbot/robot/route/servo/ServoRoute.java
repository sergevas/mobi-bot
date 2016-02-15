package xyz.sergevas.iot.bcbot.robot.route.servo;

import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_SPEED_MODE_HEADER;

import org.apache.camel.builder.RouteBuilder;

public class ServoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:robot.move.forward")
		    .choice()
		    .when(header(ROBOT_SPEED_MODE_HEADER).isEqualToIgnoreCase("{{servo.speed.mode.slow}}")).to("exec:")
		    .when(header(ROBOT_SPEED_MODE_HEADER).isEqualToIgnoreCase("{{servo.speed.mode.medium}}")).to("exec:")
		    .when(header(ROBOT_SPEED_MODE_HEADER).isEqualToIgnoreCase("{{servo.speed.mode.fast}}")).to("exec:");
	}
}
