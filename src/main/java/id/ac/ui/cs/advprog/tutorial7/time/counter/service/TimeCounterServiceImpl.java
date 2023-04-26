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

        String result = "";
        if (isAdd) {
            result = add(totalMinutes, hours, minutes);
        } else {
            result = subtract(totalMinutes, hours, minutes);
        }
        return printResult(time, hours, minutes, isAdd, result);
    }

    private String add(int totalMinutes, int hours, int minutes) {
        totalMinutes += hours * 60 + minutes;
        int newHours = (totalMinutes / 60) % 24;
        int newMinutes = totalMinutes % 60;
        return String.format("%02d:%02d", newHours, newMinutes);
    }

    private String subtract(int totalMinutes, int hours, int minutes) {
        totalMinutes -= hours * 60 + minutes;
        // handle negative value
        totalMinutes = (totalMinutes % (24 * 60)) + 24 * 60;

        int newHours = (totalMinutes / 60) % 24;
        int newMinutes = totalMinutes % 60;
        return String.format("%02d:%02d", newHours, newMinutes);
    }

    private String printResult(String time, int hours, int minutes, boolean add, String result) {
        if (hours == 0 && minutes == 0) {
            return result;
        }
        String toBe = getAfterOrBefore(add);
        String hourText = getTextHour(hours);
        String minuteText = getTextMinute(minutes);
        return String.format("%s%s%s %s is %s", hourText, minuteText, toBe, time, result);
    }

    private String getAfterOrBefore(boolean add) {
        if (add) {
            return "after";
        }
        return "before";
    }

    private String getTextHour(int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return String.format("%d hour ", n);
            default:
                return String.format("%d hours ", n);
        }
    }

    private String getTextMinute(int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return String.format("%d minute ", n);
            default:
                return String.format("%d minutes ", n);
        }
    }
}
