package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        return "Wylosowano liczbe: " + randomNum ;
    }

    // zadanie 1 - przekazywanie parametrów
    @GetMapping(value="/random/{max}/{min}", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String maxParamRandom(@PathVariable("max") int max,
                                 @PathVariable("min") int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min)+min;
        return "Użytkownik podał wartości: " + max + " " + min + ".<br>" +
                "Wylosowano liczbe: " + randomNum;
    }
}
