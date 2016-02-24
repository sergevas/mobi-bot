package xyz.sergevas.iot.bcbot.coap.gateway;

public interface IConstants {
	
	public static final String ROBOT_STOP_ROUTE = "direct:robot.stop";
	public static final String ROBOT_MOVE_FORWARD_ROUTE = "direct:robot.move.forward";
	public static final String ROBOT_MOVE_BACKWARD_ROUTE = "direct:robot.move.backward";
	public static final String ROBOT_MOVE_TURN_RIGHT_ROUTE = "direct:robot.move.turn.right";
	public static final String ROBOT_MOVE_TURN_LEFT_ROUTE = "direct:robot.move.turn.left";
	
	public static final String SERVO_SPEED_MODE_STOP = "STOP";
	public static final String SERVO_SPEED_MODE_SLOW = "SLOW";
	public static final String SERVO_SPEED_MODE_MEDIUM = "MEDIUM";
	public static final String SERVO_SPEED_MODE_FAST = "FAST";
}
