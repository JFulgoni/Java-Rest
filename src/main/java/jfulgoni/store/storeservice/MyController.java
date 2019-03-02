package jfulgoni.store.storeservice;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MyController {

	@Autowired
	private CamelContext camelContext;
	
	@Autowired
	private MyService myService;

	@GetMapping("/work/{value}")
	public void myEndpoint(@PathVariable String value) {
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.send("direct:instrument", ExchangeBuilder.anExchange(camelContext).withBody(value).build());
	}
	
	@GetMapping(value = "/beer/{value}", produces = "application/json")
	public String myBeerEndpoint(@PathVariable String value) throws JsonProcessingException {
		return myService.doSomething(value);
	}

}
