package xyz.sergevas.iot.bcbot.robot.route.servo;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test; 

public class ServoRouteTest extends CamelTestSupport {
	
	@EndpointInject(uri = "exec:/bin/sh?args=-c%20%22echo%20{{servo.right.pin}}={{servo.right.speed.slow.fw}}%22")
	protected MockEndpoint endpoint;
	
	@Produce(uri = "direct:robot.move.forward")
	protected ProducerTemplate template;
    
	@Override
	 protected CamelContext createCamelContext() throws Exception {
	    CamelContext context = super.createCamelContext();
	    PropertiesComponent propertiesComponent = context.getComponent("properties", PropertiesComponent.class);
	    propertiesComponent.setLocation("bcbot.properties");
	    return context;
	}
	
	@Test
	public void testConfigure() throws Exception {
		endpoint.expectedBodiesReceived("SLOW");
		this.template.sendBody("SLOW");
		endpoint.assertIsSatisfied();
	}
}
