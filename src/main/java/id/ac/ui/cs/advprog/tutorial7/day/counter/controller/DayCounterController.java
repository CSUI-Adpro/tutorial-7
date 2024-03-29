package id.ac.ui.cs.advprog.tutorial7.day.counter.controller;

import id.ac.ui.cs.advprog.tutorial7.day.counter.core.WeekDay;
import id.ac.ui.cs.advprog.tutorial7.day.counter.dto.DayCounter;
import id.ac.ui.cs.advprog.tutorial7.day.counter.service.DayCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/day-counter")
public class DayCounterController {
    private final DayCounterService dayCounterService;

    @Autowired
    public DayCounterController(DayCounterService dayCounterService){
        this.dayCounterService = dayCounterService;
    }

    @GetMapping(path = {"", "/"})
    public String getDayCounterPage(Model model) {
        List<String> days = Arrays.stream(WeekDay.values())
                .map(WeekDay::getDay)
                .collect(Collectors.toList());
        model.addAttribute("days", days);
        model.addAttribute("dto", new DayCounter());
        return "day.counter/home";
    }

    @PostMapping(path = {"", "/"})
    public String postDayCounterPage(Model model, DayCounter dto) {
        List<String> days = Arrays.stream(WeekDay.values())
                .map(WeekDay::getDay)
                .collect(Collectors.toList());
        String result = dayCounterService.getWeekDay(dto.getDay(), dto.getN());
        model.addAttribute("days", days);
        model.addAttribute("dto", new DayCounter());
        model.addAttribute("result", result);
        return "day.counter/home";
    }


}
