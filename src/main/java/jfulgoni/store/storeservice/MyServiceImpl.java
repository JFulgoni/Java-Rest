package jfulgoni.store.storeservice;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MyServiceImpl implements MyService {
	
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public String doSomething(String value) throws JsonProcessingException {
		return mapper.writeValueAsString(new Beer(value, "5.5"));
	}
	
	public static class Beer {
		private String name;
		
		private String abv;
		
		public Beer(String name, String abv) {
			this.name = name;
			this.abv = abv;
		}
		
		public String getAbv() {
			return abv;
		}
		
		public String getName() {
			return name;
		}
	}

}
