package id.ac.ui.cs.advprog.tutorial7.time.counter.service;

import org.springframework.stereotype.Service;

@Service
public class TimeCounterServiceImpl implements TimeCounterService {

    @Override
    public String calculateTime(String time, int hours, int minutes, String operation) {
        String[] parts = time.split(":");
        int currentHours = Integer.parseInt(parts[0]);
        int currentMinutes = Integer.parseInt(parts[1]);
        int totalMinutes = currentHours * 60 + currentMinutes;
        boolean isAdd = operation.equals("add");

        int newTotalMinutes = calculateNewTotalMinutes(totalMinutes, hours, minutes, isAdd);
        String result = formatResult(newTotalMinutes);
        return printResult(time, hours, minutes, isAdd, result);
    }

    private int calculateNewTotalMinutes(int totalMinutes, int hours, int minutes, boolean isAdd) {
        int newTotalMinutes;
        if (isAdd) {
            newTotalMinutes = totalMinutes + hours * 60 + minutes;
        } else {
            newTotalMinutes = totalMinutes - hours * 60 - minutes;
            newTotalMinutes = (newTotalMinutes % (24 * 60)) + 24 * 60; // handle negative value
        }
        return newTotalMinutes;
    }

    private String formatResult(int totalMinutes) {
        int newHours = (totalMinutes / 60) % 24;
        int newMinutes = totalMinutes % 60;
        return String.format("%02d:%02d", newHours, newMinutes);
    }

    private String printResult(String time, int hours, int minutes, boolean add, String result) {
        if (hours == 0 && minutes == 0) {
            return result;
        }
        String toBe = getAfterOrBefore(add);
        String hourText = getText(hours, "hour", "hours");
        String minuteText = getText(minutes, "minute", "minutes");
        return String.format("%s%s%s %s is %s", hourText, minuteText, toBe, time, result);
    }

    private String getText(int n, String singular, String plural) {
        if (n == 0) {
            return "";
        } else if (n == 1) {
            return String.format("%d %s ", n, singular);
        } else {
            return String.format("%d %s ", n, plural);
        }
    }

    private String getAfterOrBefore(boolean add) {
        return add ? "after" : "before";
    }
}
