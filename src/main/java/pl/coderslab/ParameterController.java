package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping("/first")
public class ParameterController {

    // zadanie 3
    @GetMapping(value="/hello/{firstName}/{lastName}", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String sayHello(@PathVariable("firstName") String firstName,
                           @PathVariable("lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    // zadanie 4
    @PostMapping("/form")
    @ResponseBody
    public String handleForm(@RequestParam("paramName") String paramName,
                             @RequestParam("paramDate") String paramDate) {
        return "Hello " + paramName + " " + paramDate;
    }

}
