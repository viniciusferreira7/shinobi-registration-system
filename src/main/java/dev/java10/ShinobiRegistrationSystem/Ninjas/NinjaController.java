package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/hello-world")
    public String welcome(){
        return "Hello world";
    }
}
