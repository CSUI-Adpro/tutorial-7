package id.ac.ui.cs.advprog.tutorial7.leap.year.service;

import id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory;
import org.springframework.stereotype.Service;

@Service
public class LapYearServiceImpl implements LapYearService {

    @Override
    public String getYearCategory(long year) {
        YearCategory yearCategory = calculateYearCategory(year);
        String toBe = yearCategory.isLeapYear() ? "is" : "isn't";
        String yearCategoryString = yearCategory.toString();
        return String.format("%d %s a leap year because it is %s.", year, toBe, yearCategoryString);
    }

    private YearCategory calculateYearCategory(long year) {
        if (year % 400 == 0) {
            return YearCategory.DIVISIBLE_BY_400;
        } else if (year % 100 == 0) {
            return YearCategory.DIVISIBLE_BY_100;
        } else if (year % 4 == 0) {
            return YearCategory.DIVISIBLE_BY_4;
        } else {
            return YearCategory.NOT_DIVISIBLE_BY_4;
        }
    }
}
