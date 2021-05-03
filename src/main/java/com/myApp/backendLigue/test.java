package com.myApp.backendLigue;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hollow")
public class test {
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String hellow(){
        return "hellow anouar from java spring boot project";
    }
}
