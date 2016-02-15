package xyz.sergevas.iot.bcbot.robot.route.sensor;

import org.apache.camel.builder.RouteBuilder;

public class HcSr501Route extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("pi4j-gpio://{{hcsr501.pin.left}}?mode=DIGITAL_INPUT&state=HIGH")
		  .to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
		
		from("pi4j-gpio://{{hcsr501.pin.right}}?mode=DIGITAL_INPUT&state=HIGH")
		  .to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
	}
}
