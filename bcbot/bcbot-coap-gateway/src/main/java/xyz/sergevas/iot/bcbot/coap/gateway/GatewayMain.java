package xyz.sergevas.iot.bcbot.coap.gateway;

import org.apache.camel.main.Main;
import org.apache.log4j.Logger;

import xyz.sergevas.iot.bcbot.coap.gateway.route.GatewayRoute;

public class GatewayMain {
	
	private static final Logger LOG = Logger.getLogger(GatewayMain.class);
	
	public static void main(String[] args) {
	    LOG.debug("Starting CoAP Gateway...");
	    Main main = new Main();
	    main.enableHangupSupport();
	    main.addRouteBuilder(new GatewayRoute());
	    try {
	    	main.run();
	    } catch (Exception e) {
	    	LOG.error("Unable to start bc-Bot CoAP Gateway... ", e);
	    	throw new RuntimeException("Unable to start bc-Bot CoAP Gateway... ", e);
	    }
	}
}
