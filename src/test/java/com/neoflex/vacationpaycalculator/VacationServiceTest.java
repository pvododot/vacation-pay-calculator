package com.neoflex.vacationpaycalculator;


import com.neoflex.vacationpaycalculator.dto.ResponseDTO;
import com.neoflex.vacationpaycalculator.dto.VacationDTO;
import com.neoflex.vacationpaycalculator.service.VacationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacationServiceTest {
    private VacationService vacationService;

    @BeforeEach
    void init() {
        vacationService = new VacationService();
    }

    @AfterEach
    void teardown() {
        vacationService = null;
    }

    @Test
    void calculationOfVacationPayByDays() {
        ResponseDTO actual =
                vacationService.
                        selectData(new VacationDTO(100000.0, 5,
                                null, null));
        assertEquals(17064.85, actual.getAmountOfVocationPay());
    }

    @Test
    void calculationOfVacationPayByDates() {
        ResponseDTO actual =
                vacationService.selectData(new VacationDTO(100000.0, null,
                        LocalDate.of(2023, 5, 15),
                        LocalDate.of(2023, 5, 22)));
        assertEquals(17064.85, actual.getAmountOfVocationPay());
    }

}
