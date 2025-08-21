package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class FreeTimeController {

    @GetMapping(value="/freetimecheck", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String freetimecheck() {

        //LocalDateTime now = LocalDateTime.now();
        LocalDateTime now = LocalDateTime.of(2020, 1, 1, 4, 45);

        String nowStr = now.toString();
        String day = now.getDayOfWeek().toString();
        int hour = now.getHour();


        if (day.equals("SATURDAY") || day.equals("SUNDAY")) {
            return "Wolne";
        }
        else if (hour>9 && hour<17) {
            return "Nie dzwoń, pracuję";
        }
        else {
            return "Po pracy";
        }

    }
}
