package id.ac.ui.cs.advprog.tutorial7.leap.year.core;

public enum YearCategory {
    NOT_DIVISIBLE_BY_4(false),
    DIVISIBLE_BY_4(true),
    DIVISIBLE_BY_100(false),
    DIVISIBLE_BY_400(true);

    private final boolean isLeapYear;

    YearCategory(boolean isLeapYear) {
        this.isLeapYear = isLeapYear;
    }
    
    public boolean isLeapYear() {
        return this.isLeapYear;
    }
}
