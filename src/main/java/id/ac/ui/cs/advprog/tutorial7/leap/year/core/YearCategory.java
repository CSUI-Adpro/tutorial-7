package id.ac.ui.cs.advprog.tutorial7.leap.year.core;


public enum YearCategory {
    NOT_DIVISIBLE_BY_4(false),
    DIVISIBLE_BY_4(true),
    DIVISIBLE_BY_100(false),
    DIVISIBLE_BY_400(true);
    
    private final boolean leapYear;
    YearCategory(boolean isLeapYear){
        this.leapYear = isLeapYear;
    }
    
    public boolean isLeapYear(){
        return this.leapYear;
    }
    
    
    /*
    I think I missed a method that will be used so often in the future.
    but I don't know what, so for now I'll just leave this comment here
    to remind me  -- code author
     */
    
    
    @Override
    public String toString() {
        /*
        I'll refactor some parts of the other methods over here when I have time.
        For now, I'll just leave it blank. -- code author <3
         */
        return null;
    }
    
}
