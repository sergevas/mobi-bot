package xyz.sergevas.iot.bcbot.robot.route.sensor;

import static xyz.sergevas.iot.bcbot.robot.common.IConstants.GPIO_PIN_HCSR505_PIN_LEFT;

import org.apache.camel.builder.RouteBuilder;

public class HcSr505Route extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("pi4j-gpio://" + GPIO_PIN_HCSR505_PIN_LEFT + "?mode=DIGITAL_INPUT&state=LOW")
		  .to("log:xyz.sergevas.iot.bcbot?level=DEBUG&showHeaders=true");
	}
}
