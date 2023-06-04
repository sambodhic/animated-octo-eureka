package com.animated.octo.eureka.demo.endpoint;

import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.animated.octo.eureka.demo.InputSOATest;
import com.animated.octo.eureka.demo.ObjectFactory;
import com.animated.octo.eureka.demo.OutputSOATest;

import jakarta.xml.bind.JAXBElement;

@Endpoint
public class WebServiceEndpoint {

	private static final String NAMESPACE_URI = "http://demo.eureka.octo.animated.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
	@ResponsePayload
	public JAXBElement<OutputSOATest> hello(@RequestPayload JAXBElement<InputSOATest> request) {

		String outputString = "Hello " + request.getValue().getTest() + "!";

		ObjectFactory factory = new ObjectFactory();
		OutputSOATest response = factory.createOutputSOATest();
		response.setResult(outputString);		
		return createJaxbElement(response, OutputSOATest.class);
	}

	private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
		return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
	  }
}