package id.ac.ui.cs.advprog.tutorial7.leap.year.controller;

import id.ac.ui.cs.advprog.tutorial7.leap.year.dto.LeapYear;
import id.ac.ui.cs.advprog.tutorial7.leap.year.service.LapYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/leap-year")
public class LeapYearController {
    private final LapYearService lapYearService;

    @Autowired
    public LeapYearController(LapYearService lapYearService) {
        this.lapYearService = lapYearService;
    }

    @GetMapping(path = {"", "/"})
    public String getLeapYearPage(Model model) {
        model.addAttribute("dto", new LeapYear());
        return "leap.year/home";
    }

    @PostMapping(path = {"", "/"})
    public String postLeapYearPage(Model model, LeapYear dto) {
        String result = lapYearService.getYearCategory(dto.getYear());
        model.addAttribute("dto", new LeapYear());
        model.addAttribute("result", result);
        return "leap.year/home";
    }
}
