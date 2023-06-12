import java.time.*;
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day); 
        DayOfWeek dayOfWeek = DayOfWeek.from(date);
        String dayD = dayOfWeek.name();
        int length = dayD.length();
        String days = dayD.substring(1,length).toLowerCase();
        return dayD.charAt(0)+days;


        
    }
}
