package com.glsib.soapweb.websoap;

import com.glsib.soapweb.Add;
import com.glsib.soapweb.AddResponse;
import com.glsib.soapweb.Calculator;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://glsi.com/soapweb/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Add")
    @ResponsePayload
    public AddResponse add(@RequestPayload Add request) {
        int intA = request.getIntA();
        int intB = request.getIntB();
        Calculator calculator = new Calculator();
        int result = calculator.getCalculatorSoap().add(intA, intB);
        AddResponse response = new AddResponse();
        response.setAddResult(result);
        return response;
    }
}
