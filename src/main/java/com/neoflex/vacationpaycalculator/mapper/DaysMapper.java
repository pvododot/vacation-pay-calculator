package com.neoflex.vacationpaycalculator.mapper;

import com.neoflex.vacationpaycalculator.dto.VacationDTO;
import com.neoflex.vacationpaycalculator.util.HolidaysDict;

import java.time.DayOfWeek;
import java.util.stream.Stream;

public class DaysMapper {
    private DaysMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static long mapDatesToDays(VacationDTO vacationDTO, HolidaysDict holidaysDict) {
        return Stream.iterate(vacationDTO.getStartVacation(), date -> date.plusDays(1))
                .limit(vacationDTO.getEndVacation().getDayOfMonth() - vacationDTO.getStartVacation().getDayOfMonth())
                .filter(localDate -> (localDate.getDayOfWeek() != DayOfWeek.SATURDAY) && (localDate.getDayOfWeek() != DayOfWeek.SUNDAY))
                .filter(localDate -> !holidaysDict.getHolidays().contains(localDate))
                .count();
    }
}
