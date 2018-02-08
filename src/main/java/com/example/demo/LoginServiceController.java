package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginServiceController {
	@Autowired
	private final CounterService counterService;
    
    public LoginServiceController(CounterService counterService) {
        this.counterService = counterService;
    }
     
    @RequestMapping("/loginSuccess")
    @ResponseBody
    public boolean loginSuccess(String userName, char[] password) {
        counterService.increment("counter.login.success");
        return true;
    }
    
    @RequestMapping("/loginFail")
    @ResponseBody
    public boolean loginFail(String userName, char[] password) {
        counterService.increment("counter.login.failure");
        return false;
    }
}
