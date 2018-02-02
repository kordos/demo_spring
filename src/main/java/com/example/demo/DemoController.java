package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World from Java project!";
    }

    /**
     * Introduction via JSON
     *
     * @param name PathVariable - retrieved from URL
     *
     * @return serialized UserName model
     */
    @ResponseBody
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = "application/json")
    public UserName name(@PathVariable("name") String name) {
        return new UserName("Hello " + name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoController.class, args);
    }
}