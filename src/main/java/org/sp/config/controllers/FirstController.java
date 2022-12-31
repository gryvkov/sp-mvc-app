package org.sp.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.sp.models.Calculator;


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
        String page = "first/story-page";
        return page;
    }


    @GetMapping("/calculator")
    public String getCalculator(@RequestParam(value = "a", required = false) String a,
                                @RequestParam(value = "b", required = false) String b,
                                @RequestParam(value = "action", required = false) String action,
                                Model model) {

        if (a.equals("") || b.equals("") || action.equals("")) {
            model.addAttribute("res", "Calculation result = unknown");
        } else {
            Calculator c = new Calculator(action, Integer.parseInt(a), Integer.parseInt(b));
            var res = c.getRes();
            model.addAttribute("res", "Calculation result = " + res);
        }

        String page = "first/calculator-page";
        return page;
    }


}


