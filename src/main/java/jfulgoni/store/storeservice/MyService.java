package jfulgoni.store.storeservice;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MyService {
	
	String doSomething(String value) throws JsonProcessingException;

}
