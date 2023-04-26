package id.ac.ui.cs.advprog.tutorial7.leap.year.controller;

import id.ac.ui.cs.advprog.tutorial7.leap.year.dto.LeapYearDTO;
import id.ac.ui.cs.advprog.tutorial7.leap.year.service.lpYr_srvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/leap-year")
public class LeapYearController {
    private final lpYr_srvc lpYr_srvc;
    @Autowired
    public LeapYearController(lpYr_srvc lpYr_srvc){
        this.lpYr_srvc = lpYr_srvc;
    }

    @GetMapping(path = {"", "/"})
    public String getLeapYearPage(Model model) {
        model.addAttribute("dto", new LeapYearDTO());
        return "leap.year/home";
    }

    @PostMapping(path = {"", "/"})
    public String postLeapYearPage(Model model, LeapYearDTO dto) {
        String result = lpYr_srvc.get_year_categoryAsStr(dto.getYear());
        model.addAttribute("dto", new LeapYearDTO());
        model.addAttribute("result", result);
        return "leap.year/home";
    }
}
