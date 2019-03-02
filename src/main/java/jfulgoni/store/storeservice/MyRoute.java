package jfulgoni.store.storeservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyRoute extends RouteBuilder {

	Logger myLog = Logger.getLogger(MyRoute.class);

	@Override
	public void configure() throws Exception {
//		restConfiguration().component("restlet").host("localhost").port("8080");

//		rest("/work").get().to("direct:instrument");		

		from("direct:instrument").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				myLog.info(exchange.getMessage().getBody(String.class));

			}
		});
	}

}
