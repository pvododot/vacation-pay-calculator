package com.neoflex.vacationpaycalculator.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class VacationDTO {
    private Double averageSalary;
    private Integer vacationDays;
    private LocalDate startVacation;
    private LocalDate endVacation;

}
