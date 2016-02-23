package xyz.sergevas.iot.bcbot.robot.route.servo;

import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_MOVE_BACKWARD_ROUTE;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_MOVE_FORWARD_ROUTE;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_MOVE_TURN_LEFT_ROUTE;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_MOVE_TURN_RIGHT_ROUTE;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.ROBOT_STOP_ROUTE;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.SERVO_SPEED_MODE_FAST;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.SERVO_SPEED_MODE_MEDIUM;
import static xyz.sergevas.iot.bcbot.robot.common.IConstants.SERVO_SPEED_MODE_SLOW;

import org.apache.camel.builder.RouteBuilder;

public class ServoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from(ROBOT_STOP_ROUTE).to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.idle}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.idle}}%20%3E%20/dev/servoblaster%22");
		
		from(ROBOT_MOVE_FORWARD_ROUTE)
		    .choice()
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_SLOW))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.slow.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.slow.fw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_MEDIUM))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.medium.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.medium.fw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_FAST))
		        .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.fast.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.fast.fw}}%20%3E%20/dev/servoblaster%22")
		    .end().to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
		
		from(ROBOT_MOVE_BACKWARD_ROUTE)
		    .choice()
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_SLOW))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.slow.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.slow.bw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_MEDIUM))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.medium.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.medium.bw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_FAST))
		        .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.fast.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.fast.bw}}%20%3E%20/dev/servoblaster%22")
		    .end().to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
		
		from(ROBOT_MOVE_TURN_RIGHT_ROUTE)
		    .choice()
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_SLOW))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.slow.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.slow.fw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_MEDIUM))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.medium.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.medium.fw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_FAST))
		        .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.fast.bw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.fast.fw}}%20%3E%20/dev/servoblaster%22")
		    .end().to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
		
		from(ROBOT_MOVE_TURN_LEFT_ROUTE)
		    .choice()
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_SLOW))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.slow.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.slow.bw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_MEDIUM))
		            .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.medium.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.medium.bw}}%20%3E%20/dev/servoblaster%22")
		        .when(bodyAs(String.class).isEqualToIgnoreCase(SERVO_SPEED_MODE_FAST))
		        .to("exec:sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.fast.fw}}%20%3E%20/dev/servoblaster%20;%20echo%20{{servo.left.pin}}={{servo.left.speed.fast.bw}}%20%3E%20/dev/servoblaster%22")
		    .end().to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
	}
}
