package com.glsib.soapweb.websoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyApiController {
    @Autowired
    ServiceImpl serviceimpl;
    // Exposition du service soap Consommé
    @GetMapping("/add")
    public String addition(@RequestParam("a") int a, @RequestParam("b") int b) {
        int result = serviceimpl.getAddResult(a, b);
        return "Result: " + result;
    }
    @GetMapping("/sub")
    public String substract(@RequestParam("a") int a, @RequestParam("b") int b) {
        int result = serviceimpl.getSubResult(a, b);
        return "Result: " + result;
    }
    @GetMapping("/mul")
    public String multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        int result = serviceimpl.getMulResult(a, b);
        return "Result: " + result;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("a") int a, @RequestParam("b") int b) {
        if (b != 0) {
            int result = serviceimpl.getDivResult(a, b);
            return "Result: " + result;
        }
        return "Division Excexption";
    }
    // Consommation de L'API REST
    @GetMapping("/user")
    public List<Object> listeUser() {
        return serviceimpl.getAllUsers();
    }


}
