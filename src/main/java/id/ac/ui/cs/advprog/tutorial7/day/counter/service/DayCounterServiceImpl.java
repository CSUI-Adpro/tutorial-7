package id.ac.ui.cs.advprog.tutorial7.day.counter.service;

import id.ac.ui.cs.advprog.tutorial7.day.counter.core.WeekDay;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
public class DayCounterServiceImpl implements DayCounterService {
    @Override
    public String getWeekDay(String day, int n) {
        WeekDay fromDayEnum = WeekDay.dayMap.get(day.toLowerCase());

        if (fromDayEnum == null) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }

        int newIndex = calculateNewIndex(fromDayEnum, n);
        WeekDay toDayEnum = WeekDay.values()[newIndex];

        String toBe = n < 0 ? "was" : "is";
        String timeToBe = n < 0 ? "ago before" : "in the future after";

        return String.format("%d day(s) %s %s %s %s.", abs(n), timeToBe, fromDayEnum.getDay(), toBe, toDayEnum.getDay());
    }

    private int calculateNewIndex(WeekDay fromDayEnum, int n) {
        int currentIndex = fromDayEnum.ordinal();
        int numberOfDaysInAWeek = WeekDay.values().length;

        int newIndex = (currentIndex + n) % numberOfDaysInAWeek;
        if (newIndex < 0) {
            newIndex += numberOfDaysInAWeek;
        }

        return newIndex;
    }
}
