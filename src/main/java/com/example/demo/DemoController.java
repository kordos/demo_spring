package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class DemoController {

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

    @RequestMapping("/template")
    public String template(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name + " hahaha...");
        // return template name
        return "template";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoController.class, args);
    }
}