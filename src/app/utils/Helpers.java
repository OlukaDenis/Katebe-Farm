/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Eco
 */
public class Helpers {

    public Helpers() {
    }
    
    
    public static int daysBetweenDate(String dueDate) {
        LocalDate dt1 = LocalDate.parse(currentDate());
        LocalDate dt2 = LocalDate.parse(dueDate);
        
        long diff = ChronoUnit.DAYS.between(dt1, dt2);
        
        return Math.abs((int)diff);
    }
    
    public static String currentDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = df.format(now);
        
        return today;
    }
}
