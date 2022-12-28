package org.sp.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FirstController {

    @GetMapping("/main")
    public String GetGreetingPage(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "surname", required = false) String surname, Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);
        String page = "first/main-page";
        return page;
    }

    @GetMapping("/leave")
    public String sayGoodbye() {
        String page = "first/leave-page";
        return page;
    }

    @GetMapping("/story")
    public String tellStory() {
        String page = "second/story-page";
        return page;
    }


    @GetMapping("/calculator")
    public String getCalculator(@RequestParam(value = "a", required = false) int a,
                                @RequestParam(value = "b", required = false) int b,
                                @RequestParam(value = "action", required = false) String action,
                                Model model) {

        double res = Double.MIN_VALUE;

        switch (action) {
            case "mult":
                res = a * b;
                break;
            case "div":
                res = a / (double) b;
                break;
            case "sub":
                res = a - b;
                break;
            case "add":
                res = a + b;
                break;
        }

        if (res == Double.MIN_VALUE) {
            model.addAttribute("res", "Calculation result = unknown");
        } else {
            model.addAttribute("res", "Calculation result = " + res);
        }


        String page = "second/calculator-page";
        return page;
    }

}


