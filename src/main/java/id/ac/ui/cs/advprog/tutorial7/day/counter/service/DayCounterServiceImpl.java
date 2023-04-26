package id.ac.ui.cs.advprog.tutorial7.day.counter.service;

import id.ac.ui.cs.advprog.tutorial7.day.counter.core.WeekDay;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
public class DayCounterServiceImpl implements DayCounterService {
    @Override
    public String getWeekDayAsString(String day, int n) {

        WeekDay fromDayEnum = WeekDay.dayMap.get(day.toLowerCase());
        String fromDay = fromDayEnum.getDay();

        if (fromDayEnum == null) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }

        // Calculate the n-th day after or before a certain day
        // 7 is the number of days in a week
        int newIndex = (fromDayEnum.ordinal() + n) % 7;
        if (newIndex < 0) {
            newIndex += 7;
        }

        WeekDay toDayEnum = WeekDay.values()[newIndex];
        String toDay = toDayEnum.getDay();

        String toBe = n < 0 ? "was" : "is";
        final var timeToBe = n < 0 ? "ago before" : "in the future after";

        return String.format("%d day(s) %s %s %s %s.", abs(n), timeToBe, fromDay, toBe, toDay);
    }

}
