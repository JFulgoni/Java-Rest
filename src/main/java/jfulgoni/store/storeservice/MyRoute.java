package jfulgoni.store.storeservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyRoute extends RouteBuilder {

	// I don't know why this isn't working right now
	private Logger myLog = Logger.getLogger(MyRoute.class);

	@Autowired
	private MyService myService;

	@Override
	public void configure() throws Exception {
		from("direct:instrument").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				String value = exchange.getMessage().getBody(String.class);
				myLog.debug(value);
				String result = myService.doSomething("Camel " + value);
				myLog.debug(result);
				System.err.println(result);
				exchange.getMessage().setBody(result);
			}
		});
	}

}
