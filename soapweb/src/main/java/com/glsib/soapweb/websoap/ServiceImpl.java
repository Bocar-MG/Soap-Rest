package com.glsib.soapweb.websoap;

import com.glsib.soapweb.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public int getAddResult(int intA, int intB) {
        Calculator calculator = new Calculator();
        return calculator.getCalculatorSoap().add(intA,intB);
    }
    @Override
    public int getSubResult(int intA, int intB) {
        Calculator calculator = new Calculator();
        return calculator.getCalculatorSoap().subtract(intA,intB);
    }
    @Override
    public int getMulResult(int intA, int intB) {
        Calculator calculator = new Calculator();
        return calculator.getCalculatorSoap().multiply(intA,intB);
    }
    @Override
    public int getDivResult(int intA, int intB) {
        Calculator calculator = new Calculator();
        return calculator.getCalculatorSoap().divide(intA,intB);
    }
    @Override
    public List<Object> getAllUsers() {
        // l'adresse du REst API consommé
        String rest_api_url = "https://jsonplaceholder.typicode.com/users";
        Object[] listeUser = restTemplate.getForObject(rest_api_url,Object[].class);

        return Arrays.asList(listeUser);
    }
}
