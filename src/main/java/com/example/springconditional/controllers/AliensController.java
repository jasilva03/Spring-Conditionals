package com.example.springconditional.controllers;

import com.example.springconditional.conditionals.MyConditional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//check if the property is present in the application.properties file, if so then checks the value.
@ConditionalOnProperty(name = "aliens.greet", havingValue = "true")

//Check if the resource is present in the project.
@ConditionalOnResource(resources = "alienFile.txt")

//Check if the fully qualified mentioned class is in the project.
@ConditionalOnClass(name="com.example.springconditional.controllers.OtherClass")

//Create my own conditional class
@Conditional(MyConditional.class)

@RestController
@RequestMapping("/aliens")
public class AliensController {

    @GetMapping("/greetings")
    public String greetings() {

        return "Hello Alien, welcome to my planet.";

    }

}
