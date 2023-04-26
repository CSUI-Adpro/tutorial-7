package id.ac.ui.cs.advprog.tutorial7.day.counter.core;

import java.util.HashMap;
import java.util.Map;

public enum WeekDay {
    SUN("Sunday"),
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday");

    private final String day;

    public String getDay() {
        return this.day;
    }

    WeekDay(String day) {
        this.day = day;
    }

    public static final Map<String, WeekDay> dayMap = new HashMap<>();

    static {
        for (WeekDay day : WeekDay.values()) {
            dayMap.put(day.day.toLowerCase(), day);
        }
    }

}
