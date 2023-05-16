package com.neoflex.vacationpaycalculator.util;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Временное решение, лучше перенести в конфиг
 */
public class HolidaysDictHardcoded implements HolidaysDict{
    public  List<LocalDate> getHolidays() {
        List<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 1));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 2));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 3));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 4));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 5));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 6));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 7));
        holidays.add(LocalDate.of(Year.now().getValue(), 1, 8));
        holidays.add(LocalDate.of(Year.now().getValue(), 2, 23));
        holidays.add(LocalDate.of(Year.now().getValue(), 3, 8));
        holidays.add(LocalDate.of(Year.now().getValue(), 5, 1));
        holidays.add(LocalDate.of(Year.now().getValue(), 5, 9));
        holidays.add(LocalDate.of(Year.now().getValue(), 6, 12));
        holidays.add(LocalDate.of(Year.now().getValue(), 11, 4));
        return holidays;
    }
}
