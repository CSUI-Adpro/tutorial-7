package id.ac.ui.cs.advprog.tutorial7.leap.year.service;

import id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory;
import org.springframework.stereotype.Service;

import static id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory.DIVISIBLE_BY_4;
import static id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory.DIVISIBLE_BY_400;

@Service
public class lpYrsrvc_impl implements lpYr_srvc {
    /*
    Hello.
    Guess what!
    I have written comments so that people can read my code easily.
    Now I'm confident that you and all other people will be able to read my code in no time! xd
    
    - Code Author
     */
    
    @Override
    public String get_year_categoryAsStr(long yr) {  // yr = year
        // check if the year is divisible by 4, by 100, by 400, or not divisible at all.
        YearCategory yearCategory;
        if (yr % 4 == 0){
            if (yr % 100 == 0){
                if (yr % 400 == 0){
                    yearCategory = DIVISIBLE_BY_400;
                }else{
                    yearCategory = YearCategory.DIVISIBLE_BY_100;
                }
            }else{
                yearCategory = DIVISIBLE_BY_4;
            }
        }else{
            yearCategory = YearCategory.NOT_DIVISIBLE_BY_4;
        }
        
        
        var toBe = "to be determined";
        if (yearCategory.isLeapYear()) {
            toBe = "is";
        } else {
            toBe = "isn't";
        }
    
    
        // the reason why the year is leap/not-leap year
        // ctgr = category. This string explains why the given year is a / not-a leap year
        String year_ctgr_stringversion = yearCategory.toString();
    
        if (yearCategory == DIVISIBLE_BY_400){
            year_ctgr_stringversion = "divisible by 400";
        }else{
            if (yearCategory == YearCategory.DIVISIBLE_BY_100){
                year_ctgr_stringversion = "divisible by 100";
            }else{
                // check if it is divisible by 4 or not
                
                // get the name
                String temp = yearCategory.name();
                
                // strip
                Character temp3 = '_';
                
                // space
                Character temp4 = ' ';
                
                // convert to lower case
                String temp2 = temp.toLowerCase();
                
                // replace strip to space
                String temp5 = temp2.replace(temp3, temp4);
                if (yearCategory == YearCategory.DIVISIBLE_BY_4){
                    year_ctgr_stringversion = temp5;  // set year category string version to be
                }else{
                    year_ctgr_stringversion = yearCategory.name().replace('_', ' ').toLowerCase();
                }
            }
        }
        
        // return the result
        return String.format("%d %s a leap year because it is %s.", yr, toBe, year_ctgr_stringversion);
    }
}
